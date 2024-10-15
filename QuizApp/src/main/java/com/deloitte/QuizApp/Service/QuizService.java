package com.deloitte.QuizApp.Service;

import com.deloitte.QuizApp.Model.Question;
import com.deloitte.QuizApp.Model.QuestionWrapper;
import com.deloitte.QuizApp.Model.Quiz;
import com.deloitte.QuizApp.Repository.QuestionRepo;
import com.deloitte.QuizApp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo quesRepo;

    public ResponseEntity<String> createQuiz(String category, int numq, String title) {
        List<Question> questions = quesRepo.findRandomQuestionsByCategory(category, numq);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public Integer getId(String title) {
       return quizRepo.getId(title);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestion();
        List<QuestionWrapper> questionsForUser= new ArrayList<>();
        for (Question q:questionsFromDB){
            QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getCategory(),q.getDifficultyLevel(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }
}
