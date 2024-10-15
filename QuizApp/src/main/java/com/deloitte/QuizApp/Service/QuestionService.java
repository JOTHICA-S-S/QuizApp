package com.deloitte.QuizApp.Service;

import com.deloitte.QuizApp.Model.Question;
import com.deloitte.QuizApp.Repository.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo quesRepo;


    public ResponseEntity<List<Question>> getAllQues() {
        try{
            return new ResponseEntity<>(quesRepo.findAll(), HttpStatus.OK) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
        }

    }

    public ResponseEntity<List<Question>> questionByCategory(String category) {
        try{
            return new ResponseEntity<>(quesRepo.findAllByCategory(category), HttpStatus.OK) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            quesRepo.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>("Error while adding", HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<String> UpdateQuestion(Question question) {
        try{
            quesRepo.save(question);
            return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Error while updating",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> DeleteQuestion(Integer id) {
//        ObjectId objId=new ObjectId(id);
        quesRepo.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
