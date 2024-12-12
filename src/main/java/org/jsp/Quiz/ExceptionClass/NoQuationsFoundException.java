package org.jsp.Quiz.ExceptionClass;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class NoQuationsFoundException extends RuntimeException{

	
	private String message;
	
	NoQuationsFoundException(){
		
	}
	public NoQuationsFoundException(String message){
		this.message= message;
		
	}
	
	public String getMessage() {
		
		return this.message;
	}
}
