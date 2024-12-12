package org.jsp.Quiz.contoller;

import java.util.List;

import org.jsp.Quiz.dto.QuizDto;
import org.jsp.Quiz.entity.Quiz;
import org.jsp.Quiz.responseStrcture.ResponseStrcture;
import org.jsp.Quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

	
	@Autowired
	private QuizService service;
	
	

	@PostMapping("/quiz")
	public ResponseEntity<ResponseStrcture<Quiz>> saveQuiz(@RequestBody Quiz quiz){
		
		
		
		
		return service.saveQuiz(quiz);
	}
	
	@GetMapping("/quiz")
	public ResponseEntity<ResponseStrcture<List<QuizDto>>> findAllQuations(){
		return service.findAllQuations();
		
	}
	
	@GetMapping("/quiz/{id}")
	public ResponseEntity<ResponseStrcture<QuizDto>> findQuationById(@RequestParam int id){
		
		return service.findQuationById(id);
	}
	
	@GetMapping("/quiz/title/{title}")
	public ResponseEntity<ResponseStrcture<QuizDto>> findQuationByTitle(@RequestParam String title){
		
		return service.findQuationByTitle(title);
	}
}
