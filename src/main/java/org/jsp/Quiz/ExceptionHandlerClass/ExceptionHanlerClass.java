package org.jsp.Quiz.ExceptionHandlerClass;

import org.jsp.Quiz.ExceptionClass.InvalidQuationIdException;
import org.jsp.Quiz.ExceptionClass.InvalidQuationTitleException;
import org.jsp.Quiz.ExceptionClass.NoQuationsFoundException;

import org.jsp.Quiz.entity.Quiz;
import org.jsp.Quiz.responseStrcture.ResponseStrcture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHanlerClass {

	
	@ExceptionHandler(NoQuationsFoundException.class)
	public ResponseEntity<?> noQuationsFoundWxception(NoQuationsFoundException e){
		
		ResponseStrcture<String> strcture = new ResponseStrcture<>();
		strcture.setHttpStatus(HttpStatus.NOT_FOUND.value());
		strcture.setMessage("No quations are found!..");
		strcture.setBody(e.getMessage());
		
	   return new ResponseEntity<>(strcture,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidQuationIdException.class)
	public ResponseEntity<?> invalidQuationIdException(InvalidQuationIdException e){
		
		ResponseStrcture<String> strcture = new ResponseStrcture<>();
		strcture.setHttpStatus(HttpStatus.NOT_FOUND.value());
		strcture.setMessage("check id!..");
		strcture.setBody(e.getMessage());
		
	   return new ResponseEntity<>(strcture,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidQuationTitleException.class)
	public ResponseEntity<?> invalidQuationIdException(InvalidQuationTitleException e){
		
		ResponseStrcture<String> strcture = new ResponseStrcture<>();
		strcture.setHttpStatus(HttpStatus.NOT_FOUND.value());
		strcture.setMessage("check title..");
		strcture.setBody(e.getMessage());
		
	   return new ResponseEntity<>(strcture,HttpStatus.NOT_FOUND);
	}
}
