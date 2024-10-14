package com.deloitte.QuizApp.Controller;

import com.deloitte.QuizApp.Model.Question;
import com.deloitte.QuizApp.Service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuizController {

    @Autowired
    private QuestionService quesServ;
    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getQuestions ()
    {
        return quesServ.getAllQues();
    }

    @GetMapping("/category/{Category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String Category)
    {
        return quesServ.questionByCategory(Category);
    }

    @PostMapping("/addQues")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return quesServ.addQuestion(question);
    }

    @PutMapping("/updateQues/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question updatequestion, @PathVariable Integer id)
    {
        updatequestion.setId(id);
        return quesServ.UpdateQuestion(updatequestion);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> DeleteQuestion(@PathVariable Integer id)
    {
        return quesServ.DeleteQuestion(id);
    }
}
