package com.example.yadaun.dao;

import com.example.yadaun.entity.TestResult;

import java.util.List;

public interface TestResultDao {
    boolean addTestResult(TestResult testResult);
    boolean updateTestResult(TestResult testResult);
    boolean deleteTestResult(int id);
    List<TestResult> showTestResult();
    TestResult findTestResultById(int id);
}
