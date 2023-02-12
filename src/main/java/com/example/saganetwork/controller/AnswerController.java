package com.example.saganetwork.controller;


import com.example.saganetwork.Entity.Answer;
import com.example.saganetwork.Entity.Question;
import com.example.saganetwork.exception.ResourceNotFoundException;
import com.example.saganetwork.repository.QuestionRp;
import com.example.saganetwork.service.AnswerService;
import com.example.saganetwork.service.QuestionService;
import com.example.saganetwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AnswerController {

    private final AnswerService answerService;

    private final UserService userService;


    private  final QuestionService questionService;

    @PostMapping("/question/{studentId}/save/{questionId}")
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer,
                                             @PathVariable(name = "studentId")Long studentId,
                                             @PathVariable(name = "questionId") Long questionId){



        Answer answer1 = questionService.getQuestionById(questionId).map(question -> {
            answer.setQuestion(question);
            answer.setStudent(userService.getUserById(studentId).orElseThrow(()-> new ResourceNotFoundException("Not found Student with id = " + studentId)));
            return answerService.saveAnswer(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Question with id = " + questionId));
        return ResponseEntity.ok(answer1);

    }


    @GetMapping("/answers/{studentId}")
    public ResponseEntity<List<Answer>> getAnswersByStudentId(@PathVariable(name = "studentId") Long studentId){
        List<Answer> answers = answerService.getAnswersByUserId(studentId);
        return ResponseEntity.ok(answers);
    }


}
