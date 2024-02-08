package com.example.yadaun.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_result_id")
    private int testResultId;


    @Column(name = "first_answer")
    private boolean first_answer;

    @Column(name = "second_answer")
    private boolean second_answer;

    @Column(name = "threeth_answer")
    private boolean threeth_answer;

    @Column(name = "fourth_answer")
    private boolean fourth_answer;

    @Column(name = "fifth_answer")
    private boolean fifth_answer;

    @Column(name = "all_answer")
    private String all_answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;


}
