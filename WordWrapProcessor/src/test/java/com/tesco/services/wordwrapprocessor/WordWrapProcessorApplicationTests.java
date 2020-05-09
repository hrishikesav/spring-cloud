package com.tesco.services.wordwrapprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tesco.services.wordwrapprocessor.service.WordWrapService;

@SpringBootTest
class WordWrapProcessorApplicationTests {
	
	@Autowired
	WordWrapService wordWrapService;
	
	@Test
	public void doWordWrapTest() {
		
		String strTest = "This is testing";
		int maxLength = 8;
		String desiredOutput = "This is \n" + 
				"testing";
		
		String actualOutput = wordWrapService.wordWrap(strTest, maxLength);
		
		assertEquals(desiredOutput, actualOutput);
	}

	@Test
	void contextLoads() {
	}

}
