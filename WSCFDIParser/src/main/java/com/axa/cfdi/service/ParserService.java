package com.axa.cfdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.cfdi.operations.ParserOperation;

@Service
public class ParserService {

	@Autowired
	ParserOperation parserController;

	public void parserToJAVA( final String cfdiJson) throws Exception {
		parserController.parserReplace(cfdiJson);
	}
	
}