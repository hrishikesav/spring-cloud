package com.hrishi.healthscience.covid19tracker20.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrishi.healthscience.covid19tracker20.bean.GeographicalLocation;
import com.hrishi.healthscience.covid19tracker20.util.CreateCasesListFromCsv;

@Controller
public class VirusDataController {

	@Autowired
	CreateCasesListFromCsv createCasesList;
	
	@GetMapping("/")
	public String home(Model model) {
		List<GeographicalLocation> allDetails = createCasesList.getAllDetails();
		int totalCases = allDetails.stream().mapToInt(data -> Integer.parseInt(data.getTotalCasesForTheDay())).sum();
		GeographicalLocation geographicalLocation = allDetails.stream().findFirst().get();
		model.addAttribute("allDetails", allDetails);
		model.addAttribute("totalCases", totalCases);
		model.addAttribute("asOfDate", geographicalLocation.getLastAvailableDate());
//		model.addAttribute("testName","TEST1");
		return "home";
	}
}
