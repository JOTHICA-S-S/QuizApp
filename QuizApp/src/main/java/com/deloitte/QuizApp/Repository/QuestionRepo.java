package com.deloitte.QuizApp.Repository;

import com.deloitte.QuizApp.Model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface QuestionRepo extends JpaRepository<Question,Integer> {


     List<Question> findAllByCategory(String category) ;


    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category")String category,@Param("numq") int numq);
}
