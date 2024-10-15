package com.deloitte.QuizApp.Controller;

import com.deloitte.QuizApp.Model.QuestionWrapper;
import com.deloitte.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getQues/{title}")
    public ResponseEntity<List<QuestionWrapper>> getQues(@PathVariable String title)
    {
        Integer id = quizServ.getId(title);
        return quizServ.getQuestions(id);
    }
}
