package com.tesco.services.wordwrapprocessor.service.impl;

import org.springframework.stereotype.Service;

import com.netflix.discovery.util.StringUtil;
import com.tesco.services.wordwrapprocessor.service.WordWrapService;


@Service
public class WordWrapServiceImpl implements WordWrapService {
	
	/**
	 * The wordwrap() takes an input string and the maxLength parameters and
	 * processes the input string to return a wrapped string based on the
	 * maxLength property.
	 * 
	 * @param inputString The input string to be word wrapped.
	 * @param maxLength The max length of characters in a line.
	 * @return String The word wrapped result string.
	 */
	public String wordWrap(String inputString, int maxLength) {
		StringBuilder strBuilder = new StringBuilder();

		StringBuilder words = new StringBuilder();
		int wordsCounter = 0;
		int spaceLeft = maxLength;
		
		if(inputString == null || inputString.trim().length() <= maxLength) {
			return inputString;
		}
		

		for(int strCounter=0; strCounter<inputString.length(); strCounter++) {
			
			/*
			 * If its a whitespace character, then we decide whether to append
			 * a word directly or after a new line character.
			 */
			if(Character.isWhitespace(inputString.charAt(strCounter))) {
				
				
				
				/*
				 * If enough space left in a line, then add directly.
				 * Else, add a new line then add the word.
				 */
				if(wordsCounter <= spaceLeft) {
					strBuilder.append(words);
					spaceLeft = spaceLeft - wordsCounter;
				} else {
					strBuilder.append("\n").append(words);
					spaceLeft = maxLength - wordsCounter;
				}
				
				/*
				 * Once a word is added, reset the word related variables.
				 */
				words.setLength(0);
				wordsCounter = 0;
				
				/*
				 * If there is enough space to add a whitespace character, then add.
				 */
				if(spaceLeft > 0) {
					strBuilder.append(inputString.charAt(strCounter));
					spaceLeft--;
				} else {
					words.append(inputString.charAt(strCounter));
					wordsCounter++;
				}
				
			} else {
				/*
				 * Keep appending the characters to a word.
				 */
				words.append(inputString.charAt(strCounter));
				wordsCounter++;
			}
		}
		
		/*
		 * Add the remaining words also to the return string.
		 */
		if(words.length() <= spaceLeft) {
			strBuilder.append(words);
		} else {
			strBuilder.append("\n").append(words);
		}
		
		return strBuilder.toString();
	}
	
	private String splitUtil(String inputString, int maxLength) {
		StringBuilder strBuilder  = new StringBuilder();
		if(!inputString.contains(" ")) {
			strBuilder.append(inputString.substring(0, maxLength)).append("-").append(inputString.substring(maxLength, inputString.length()));
		}
		
		return strBuilder.toString();
	}
	
}
