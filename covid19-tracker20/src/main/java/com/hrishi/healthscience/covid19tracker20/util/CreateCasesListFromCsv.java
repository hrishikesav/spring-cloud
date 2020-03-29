package com.hrishi.healthscience.covid19tracker20.util;

import java.io.IOException;
import java.io.StringReader;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hrishi.healthscience.covid19tracker20.bean.GeographicalLocation;

@Component
public class CreateCasesListFromCsv {

	List<GeographicalLocation> allDetails = new ArrayList<>();
	
	public List<GeographicalLocation> getAllDetails() {
		return allDetails;
	}

	public void createGeoLocationList(HttpResponse<String> httpResponse) {
		
		StringReader stringReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = null;
		String lastHeader = null;
		
		try {
			Iterable<CSVRecord> headerRecords;
			headerRecords = CSVFormat.EXCEL.withHeader().withSkipHeaderRecord(false).parse(new StringReader(httpResponse.body()));
			Set<String> headers = headerRecords.iterator().next().toMap().keySet();
			long count = headers.stream().count();
			lastHeader = headers.stream().skip(count - 1).findFirst().get();
			
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<GeographicalLocation> tempDetails = new ArrayList<>();
		for (CSVRecord record : records) {
			String country = record.get("Country/Region");
		    String state = record.get("Province/State");
		    String latestDayCases = record.get(record.size()-1);
		    if(!StringUtils.hasText(latestDayCases)) {
		    	latestDayCases = "0";
		    }
		    String previousDayCases = record.get(record.size()-2);
		    String casesIn24Hours = "0";
		    
		    if(StringUtils.hasText(latestDayCases) && StringUtils.hasText(previousDayCases)) {
		    	casesIn24Hours = Integer.toString(Integer.parseInt(latestDayCases) - Integer.parseInt(previousDayCases));
		    }
		    
			GeographicalLocation geoLocObject = new GeographicalLocation();
			geoLocObject.setState(state);
			geoLocObject.setCountry(country);
			geoLocObject.setTotalCasesForTheDay(latestDayCases);
			geoLocObject.setTotalPreviousDayCases(previousDayCases);
			geoLocObject.setCasesInLast24Hours(casesIn24Hours);
			geoLocObject.setLastAvailableDate(lastHeader);
			tempDetails.add(geoLocObject);
			geoLocObject = null;
		}
		List<GeographicalLocation> sortedList = tempDetails.stream()
				.sorted((o1, o2) -> Integer.parseInt(o2.getTotalCasesForTheDay()) - Integer.parseInt(o1.getTotalCasesForTheDay()))
				.collect(Collectors.toList());
		allDetails = sortedList;
		tempDetails = null;
		stringReader.close();
	}
	
}
