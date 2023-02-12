package com.example.saganetwork.repository;

import com.example.saganetwork.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRp extends JpaRepository<Question, Long> {

    List<Question> findByUserId(Long userId);


}
