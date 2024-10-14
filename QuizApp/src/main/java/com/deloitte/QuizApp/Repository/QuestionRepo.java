package com.deloitte.QuizApp.Repository;

import com.deloitte.QuizApp.Model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface QuestionRepo extends JpaRepository<Question,Integer> {


    default List<Question> findAllByCategory(String category) {
        return null;
    }


    void deleteAllById(Integer id);

    @Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numq")
    static List<Question> findRandomQuestionsByCategory(String category, int numq) {

        return null;
    }
}
