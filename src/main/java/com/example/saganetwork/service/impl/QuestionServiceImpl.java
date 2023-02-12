package com.example.saganetwork.service.impl;

import com.example.saganetwork.Entity.Question;
import com.example.saganetwork.Entity.User;
import com.example.saganetwork.repository.QuestionRp;
import com.example.saganetwork.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRp questionRp;

    @Override
    public Question saveQuestion(Question question) {
        return questionRp.save(question);
    }

    @Override
    public List<Question> getQuestions() {
        return questionRp.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRp.findById(id);
    }

    @Override
    public List<Question> getUserQuestions(Long userId) {
        return questionRp.findByUserId(userId);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRp.save(question);
    }
}
