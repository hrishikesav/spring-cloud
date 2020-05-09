package com.tesco.services.wordwrapapp.model.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tesco.services.wordwrapapp.model.WordWrapperModel;
import com.tesco.services.wordwrapapp.model.service.WrapperModelCleanup;

@Component
public class WrapperModelCleanupImpl implements WrapperModelCleanup {
	
	@Value("${default.line.maxlength}")
	private int defaultMaxLength;

	@Override
	public WordWrapperModel checkAttributes(WordWrapperModel wrapperModel) {
		
		if(wrapperModel.getMaxLength() == 0) {
			wrapperModel.setMaxLength(defaultMaxLength);
		}
		
		return wrapperModel;
	}

}
