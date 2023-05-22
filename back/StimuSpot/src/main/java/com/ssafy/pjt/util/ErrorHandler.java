package com.ssafy.pjt.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandler {
	
	public static ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("error occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
