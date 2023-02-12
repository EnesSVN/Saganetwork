package com.example.saganetwork.service;


import com.example.saganetwork.Entity.Answer;


import java.util.List;


public interface AnswerService {

    Answer saveAnswer(Answer answer);



    List<Answer> getAnswersByUserId(Long id);

}
