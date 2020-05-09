package com.tesco.services.wordwrapapp.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class WordWrapErrorController implements ErrorController {

	public static final String PATH = "/error";
	
	@GetMapping(value = PATH)
	public String error() {
		return "You have reached the custom error page page of Word Wrap Application.";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

}
