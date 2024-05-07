package com.pulkit.quizapp.service;


import com.pulkit.quizapp.model.Question;
import com.pulkit.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>>  getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category) , HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

//    public ResponseEntity<String> deleteQuestion(Question question) {
//        questionDao.delete(question);
//        return new ResponseEntity<>("success" , HttpStatus.OK);
//    }


    public boolean deleteQuestion(int id) {
        // Check if the question with the specified ID exists
        if (questionDao.existsById(id)) {

            questionDao.deleteById(id);
            return true;
        } else {
            // Return false if the question does not exist
            return false;
        }
    }








}
