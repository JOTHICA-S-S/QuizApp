package com.deloitte.QuizApp.Repository;

import com.deloitte.QuizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {


    @Query(value ="SELECT q.id FROM quiz q WHERE q.title=:title", nativeQuery = true)
    Integer getId(String title);


}
