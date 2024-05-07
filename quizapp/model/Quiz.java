package com.pulkit.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @ManyToMany
    private List<Question> questions;
}
