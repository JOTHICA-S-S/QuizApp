package com.deloitte.QuizApp.Service;

import com.deloitte.QuizApp.Model.Question;
import com.deloitte.QuizApp.Model.Quiz;
import com.deloitte.QuizApp.Repository.QuestionRepo;
import com.deloitte.QuizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo quesRepo;

    public ResponseEntity<String> createQuiz(String category, int numq, String title) {
        List<Question> questions;
        questions = QuestionRepo.findRandomQuestionsByCategory(category,numq);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.getQuestion(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
