package com.tesco.services.wordwrapapp.model;

import org.springframework.stereotype.Component;

@Component
public class WordWrapperModel {
	
	String sentence;
	int maxLength;
	
	public String getSentence() {
		return sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public int getMaxLength() {
		return maxLength;
	}
	
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public String toString() {
		return "WordWrapperModel [sentence=" + sentence + ", maxLength=" + maxLength + "]";
	}
	

}
