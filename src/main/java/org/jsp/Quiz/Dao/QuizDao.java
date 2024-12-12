package org.jsp.Quiz.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Quiz.dto.QuizDto;
import org.jsp.Quiz.entity.Quiz;
import org.jsp.Quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDao {
	
	@Autowired
	private QuizRepository repo;

	

	public Quiz saveQuiz(Quiz quiz) {
		
		return repo.save(quiz);
	}



	public List<Quiz> findAllQuations() {
		
		return repo.findAll();
	}



	public Optional<Quiz> findQuationById(int id) {
		
		return repo.findById(id);
	}



	public Optional<Quiz> findQuationByTitle(String title) {
	
		return repo.findQuationByTitle(title);
	}
	


}
