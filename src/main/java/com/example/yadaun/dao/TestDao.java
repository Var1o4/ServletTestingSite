package com.example.yadaun.dao;

import com.example.yadaun.entity.Test;

import java.util.List;

public interface TestDao {
    boolean addTest(Test test);
    boolean updateTest(Test test);
    boolean deleteTest(int id);
    List<Test> showTest();
    Test findTestById(int id);
    Test findTestByName(String name);
}
