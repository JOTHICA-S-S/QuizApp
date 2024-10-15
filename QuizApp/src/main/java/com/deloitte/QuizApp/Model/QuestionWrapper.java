package com.deloitte.QuizApp.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String category;
    private String difficultyLevel;

    @Column(name="option_1")
    private String option1;
    @Column(name="option_2")

    private String option2;
    @Column(name="option_3")

    private String option3;
    @Column(name="option_4")

    private String option4;
    private String question;

    public QuestionWrapper(Integer id, String category, String difficultyLevel, String option1, String option2, String option3, String option4, String question) {
        this.id = id;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.question = question;
    }
}
