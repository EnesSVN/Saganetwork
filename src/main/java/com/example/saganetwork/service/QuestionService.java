package com.example.saganetwork.service;

import com.example.saganetwork.Entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Question saveQuestion(Question question);

    List<Question> getQuestions();

    Optional<Question> getQuestionById(Long id);

    List<Question> getUserQuestions(Long userId);

    Question updateQuestion(Question question);

}
