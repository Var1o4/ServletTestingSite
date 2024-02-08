package com.example.yadaun.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int testId;

    @Column(name = "name_test")
    private String name;

    @Column(name = "question_1")
    private String question1;

    @Column(name = "question_1_option_1")
    private String question1Option1;

    @Column(name = "question_1_option_2")
    private String question1Option2;

    @Column(name = "question_1_option_3")
    private String question1Option3;

    @Column(name = "question_2")
    private String question2;

    @Column(name = "question_2_option_1")
    private String question2Option1;

    @Column(name = "question_2_option_2")
    private String question2Option2;

    @Column(name = "question_2_option_3")
    private String question2Option3;

    @Column(name = "question_3")
    private String question3;

    @Column(name = "question_3_option_1")
    private String question3Option1;

    @Column(name = "question_3_option_2")
    private String question3Option2;

    @Column(name = "question_3_option_3")
    private String question3Option3;

    @Column(name = "question_4")
    private String question4;

    @Column(name = "question_4_option_1")
    private String question4Option1;

    @Column(name = "question_4_option_2")
    private String question4Option2;

    @Column(name = "question_4_option_3")
    private String question4Option3;

    @Column(name = "question_5")
    private String question5;

    @Column(name = "question_5_option_1")
    private String question5Option1;

    @Column(name = "question_5_option_2")
    private String question5Option2;

    @Column(name = "question_5_option_3")
    private String question5Option3;

    @Column(name = "answer_1")
    private Integer answer1;

    @Column(name = "answer_2")
    private Integer answer2;

    @Column(name = "answer_3")
    private Integer answer3;

    @Column(name = "answer_4")
    private Integer answer4;

    @Column(name = "answer_5")
    private Integer answer5;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TestResult> testResults;
}
