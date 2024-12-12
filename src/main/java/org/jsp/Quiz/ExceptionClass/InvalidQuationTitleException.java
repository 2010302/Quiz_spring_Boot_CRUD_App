package org.jsp.Quiz.ExceptionClass;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class InvalidQuationTitleException extends RuntimeException{

	
	private String message;
	
	InvalidQuationTitleException(){
		
	}
	public InvalidQuationTitleException(String message){
		
		this.message=message;
	}
	public String getMessage() {
		
		return this.message;
	}
}
