package org.jsp.Quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jsp.Quiz.Dao.QuizDao;
import org.jsp.Quiz.ExceptionClass.InvalidQuationIdException;
import org.jsp.Quiz.ExceptionClass.InvalidQuationTitleException;
import org.jsp.Quiz.ExceptionClass.NoQuationsFoundException;
import org.jsp.Quiz.dto.QuizDto;
import org.jsp.Quiz.entity.Quiz;
import org.jsp.Quiz.responseStrcture.ResponseStrcture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
	
@Service
public class QuizService {

	
	@Autowired
	private QuizDao dao;

	public ResponseEntity<ResponseStrcture<Quiz>> saveQuiz(Quiz quiz) {
		quiz = dao.saveQuiz(quiz);
		ResponseStrcture<Quiz> strcture = new ResponseStrcture<>();
		strcture.setHttpStatus(HttpStatus.CREATED.value());
		strcture.setMessage("Quation  saved sucessfully");
		strcture.setBody(quiz);
		
		return new ResponseEntity<>(strcture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStrcture<List<QuizDto>>> findAllQuations() {
	    List<Quiz> quizList = dao.findAllQuations();
	    List<QuizDto> quizDtoList = new ArrayList<>();

	  
	    if (quizList != null && !quizList.isEmpty()) {
	        for (Quiz quiz : quizList) {
	            QuizDto quizDto = new QuizDto();
	            quizDto.setId(quiz.getId());
	            quizDto.setTitle(quiz.getTitle());
	            quizDto.setOptions(quiz.getOptions());
	            quizDtoList.add(quizDto);
	        }
	    }

	
	    ResponseStrcture<List<QuizDto>> responseStructure = new ResponseStrcture<>();

	  
	    if (quizDtoList.isEmpty()) {
	    	
	    	throw new NoQuationsFoundException("unable to found quations");
	    	
//	        responseStructure.setHttpStatus(HttpStatus.OK.value()); 
//	        responseStructure.setMessage("No questions found.");
//	        responseStructure.setBody(null); 
//	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    } 
	    {
	        responseStructure.setHttpStatus(HttpStatus.OK.value()); 
	        responseStructure.setMessage("All questions found successfully.");
	        responseStructure.setBody(quizDtoList); 
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    }

	    
	   
	}

	public ResponseEntity<ResponseStrcture<QuizDto>> findQuationById(int id) {
	   
	    Optional<Quiz> quizOptional = dao.findQuationById(id);
	    
	    Quiz quiz = quizOptional.get();  
	    QuizDto quizDto = new QuizDto();  
	    
	    quizDto.setId(quiz.getId());
	      quizDto.setTitle(quiz.getTitle());
	      quizDto.setOptions(quiz.getOptions());


	    ResponseStrcture<QuizDto> strcture = new ResponseStrcture<>();

	
	    if (quizOptional.isEmpty()) {
	    	
	    	throw new InvalidQuationIdException("unable to find Quation");
	    	
//	        strcture.setHttpStatus(HttpStatus.NOT_FOUND.value());  
//	        strcture.setMessage("Invalid ID. Quiz not found.");
//	        strcture.setBody(null);
//	        return new ResponseEntity<>(strcture, HttpStatus.NOT_FOUND);
	    }

	   
	   
	    
	    strcture.setHttpStatus(HttpStatus.OK.value());  
	    strcture.setMessage("Quation found successfully.");
	    strcture.setBody(quizDto); 
	    return new ResponseEntity<>(strcture, HttpStatus.OK);  
	}

	
	public ResponseEntity<ResponseStrcture<QuizDto>> findQuationByTitle(String title){
		Optional<Quiz> quiz = dao.findQuationByTitle(title);
		Quiz q = quiz.get();
		QuizDto dto = new QuizDto();
		dto.setId(q.getId());
		dto.setTitle(q.getTitle());
		dto.setOptions(q.getOptions());
		
		
		ResponseStrcture<QuizDto> strcture = new ResponseStrcture<>();

	    if (quiz.isEmpty()) {
	    	
	    	throw new InvalidQuationTitleException("unable to fetch quation");
	    	
//	        strcture.setHttpStatus(HttpStatus.NOT_FOUND.value());  
//	        strcture.setMessage("Invalid ID. Quiz not found.");
//	        strcture.setBody(null);
//		    return new ResponseEntity<>(strcture, HttpStatus.NOT_FOUND);  

	    }

	   
	   
	    
	    strcture.setHttpStatus(HttpStatus.OK.value());  
	    strcture.setMessage("Quation found successfully.");
	    strcture.setBody(dto);
	    return new ResponseEntity<>(strcture, HttpStatus.OK);  
	
		
		
	}
		
	}



	