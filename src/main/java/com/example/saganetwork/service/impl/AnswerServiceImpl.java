package com.example.saganetwork.service.impl;

import com.example.saganetwork.Entity.Answer;
import com.example.saganetwork.repository.AnswerRp;
import com.example.saganetwork.service.AnswerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRp answerRp;
    @Override
    public Answer saveAnswer(Answer answer) {
        return  answerRp.save(answer);
    }


    @Override
    public List<Answer> getAnswersByUserId(Long id) {
        return answerRp.findAnswerByStudent_Id(id);
    }


}
