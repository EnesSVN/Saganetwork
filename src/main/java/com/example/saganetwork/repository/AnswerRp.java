package com.example.saganetwork.repository;

import com.example.saganetwork.Entity.Answer;
import com.example.saganetwork.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRp extends JpaRepository<Answer, Long> {

    List<Answer> findAnswerByStudent_Id(long id);

}
