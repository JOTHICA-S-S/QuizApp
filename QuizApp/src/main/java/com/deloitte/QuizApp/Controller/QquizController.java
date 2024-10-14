package com.deloitte.QuizApp.Controller;

import com.deloitte.QuizApp.Service.QuestionService;
import com.deloitte.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QquizController {

    @Autowired
    QuizService quizServ;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq, @RequestParam String title){
//        return  new ResponseEntity<>("I am here", HttpStatus.OK);
            return  quizServ.createQuiz(category,numq,title);
    }
}
