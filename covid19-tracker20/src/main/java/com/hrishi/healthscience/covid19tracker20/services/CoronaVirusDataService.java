package com.hrishi.healthscience.covid19tracker20.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hrishi.healthscience.covid19tracker20.util.CreateCasesListFromCsv;

@Service
public class CoronaVirusDataService {
	
	private static Logger loggger = LoggerFactory.getLogger(CoronaVirusDataService.class);

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	@Autowired
	CreateCasesListFromCsv createCasesList;
	
	@PostConstruct
	@Scheduled(cron = "0 0 */4 * * *")
	private void retrieveVirusData() {
		
		/*
		 * This service is scheduled to execute the below http request every 4 hours,
		 * as mentioned in the above cron job.
		 */
		loggger.info("VIRUS_DATA_URL invoked.");
	
		HttpClient httpClient = HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(VIRUS_DATA_URL))
				.build();
		
		HttpResponse<String> httpResponse = null;
		
		try {
			httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		createCasesList.createGeoLocationList(httpResponse);
	}
}
