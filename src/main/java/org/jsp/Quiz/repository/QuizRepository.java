package org.jsp.Quiz.repository;

import java.util.Optional;

import org.jsp.Quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	
	Optional<Quiz> findQuationByTitle(String title);
	

}
