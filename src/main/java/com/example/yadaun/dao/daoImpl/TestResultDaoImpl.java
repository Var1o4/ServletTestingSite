package com.example.yadaun.dao.daoImpl;

import com.example.yadaun.dao.TestResultDao;
import com.example.yadaun.entity.TestResult;
import com.example.yadaun.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestResultDaoImpl implements TestResultDao {

    @Override
    public boolean addTestResult(TestResult testResult) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(testResult);
            tx.commit();
            session.close();
            isAdded = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateTestResult(TestResult testResult) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(testResult);
            tx.commit();
            session.close();
            isUpdated = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteTestResult(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            TestResult testResult = session.load(TestResult.class, id);
            session.delete(testResult);
            tx.commit();
            session.close();
            isDeleted = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<TestResult> showTestResult() {
        List<TestResult> testResults = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TestResult> cr = cb.createQuery(TestResult.class);
            Root<TestResult> root = cr.from(TestResult.class);
            cr.select(root);
            testResults = session.createQuery(cr).getResultList();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return testResults;
    }

    @Override
    public TestResult findTestResultById(int id) {
        TestResult testResult = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TestResult> cr = cb.createQuery(TestResult.class);
            Root<TestResult> root = cr.from(TestResult.class);
            cr.select(root).where(cb.equal(root.get("testResultId"), id));
            testResult = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return testResult;
    }
}
