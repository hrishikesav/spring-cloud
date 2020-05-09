package com.tesco.services.wordwrapapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tesco.services.wordwrapapp.model.WordWrapperModel;
import com.tesco.services.wordwrapapp.model.service.WrapperModelCleanup;

@RestController
public class WordWrapController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WrapperModelCleanup modelCleanup;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Word Wrap Service.";
	}
	
	@PostMapping("/wordwrap")
	public String doWordWrap(@RequestBody WordWrapperModel wordWrapperModel ) {
		
		wordWrapperModel = modelCleanup.checkAttributes(wordWrapperModel);
		
		HttpEntity<WordWrapperModel> httpEntity = new HttpEntity<WordWrapperModel>(wordWrapperModel);
		String responseString = restTemplate.postForObject("http://WordWrapProcessor/wordwrap", httpEntity, String.class);
		
		System.out.println("responseString-" + responseString);
		return responseString;
	}

}
