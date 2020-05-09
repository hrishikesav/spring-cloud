package com.tesco.services.wordwrapprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.services.wordwrapprocessor.model.WordWrapperModel;
import com.tesco.services.wordwrapprocessor.service.WordWrapService;


@RestController
public class WordWrapProcessingController {
	
	@Autowired
	WordWrapService wordWrapService;
	
	@PostMapping("/wordwrap")
	public String doWordWrap(@RequestBody WordWrapperModel wordWrapperModel ) {
		System.out.println("Inside post 8082");
		
		String wordWrap = wordWrapService.wordWrap(wordWrapperModel.getSentence(), wordWrapperModel.getMaxLength());
		System.out.println("responseString-" + wordWrap);
		return wordWrap;
	}
}
