package com.example.saganetwork.controller;

import com.example.saganetwork.Entity.Answer;
import com.example.saganetwork.Entity.Question;
import com.example.saganetwork.Entity.User;
import com.example.saganetwork.repository.AnswerRp;
import com.example.saganetwork.service.AnswerService;
import com.example.saganetwork.service.QuestionService;
import com.example.saganetwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {

    private final QuestionService questionService;


    private final UserService userService;


    @GetMapping("/questions")
    public ResponseEntity<List<Question>>getQuestions(){
        return ResponseEntity.ok().body(questionService.getQuestions());
    }

    @GetMapping("/teacher/{teacherId}/questions")
    public ResponseEntity<List<Question>>getUserQuestions(@PathVariable(name = "teacherId") Long userId){
        List<Question> questions = questionService.getUserQuestions(userId);
        return ResponseEntity.ok(questions);
    }

    @GetMapping ("/question/student/{studentId}")
    public ResponseEntity<List<Question>> getQuestionByStudentId(@PathVariable(name = "studentId") Long studentId){

        List<Question> questions = questionService.getQuestions();

        List<Question> uniqueQuestion = questions.stream().filter(question -> !question.getAnswers().stream().anyMatch(answer -> answer.getStudent().getId().equals(studentId))).toList();

        return ResponseEntity.ok(uniqueQuestion);
    }


    @PostMapping("/question/{teacherId}/save")
    public ResponseEntity<Question>saveQuestion(@RequestBody Question question,
                                                @PathVariable(name = "teacherId") Long teacherId) {
        User teacher = userService.getUserById(teacherId).orElseThrow(()-> new RuntimeException("Not found Teacher with id = " + teacherId));
        boolean isTeacher = teacher.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ROLE_TEACHER"));

        if (!isTeacher){
            return ResponseEntity.status(401).build();
        }
        question.setUser(teacher);
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    @GetMapping ("/question/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable(name = "id") Long id){

        Question question = questionService.getQuestionById(id)
                .orElseThrow(()-> new ResolutionException("Not found comment with id = " + id));

        return ResponseEntity.ok(question);
    }

    @PutMapping("/update/question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable(name = "id") Long id, @RequestBody Question question ){
        Question question1 =  questionService.getQuestionById(id)
                .orElseThrow(()-> new ResolutionException("Not founf comment with id = " + id));

        boolean isTeacher = question1.getUser().getRoles().stream().anyMatch(role -> role.getRoleName().equals("ROLE_TEACHER"));

        if (!isTeacher){
            return ResponseEntity.status(401).build();
        }

        question1.setTitle(question.getTitle());
        question1.setDescription(question.getDescription());
        question1.setAnswers(question.getAnswers());
        return ResponseEntity.ok(questionService.saveQuestion(question1));
    }

}
