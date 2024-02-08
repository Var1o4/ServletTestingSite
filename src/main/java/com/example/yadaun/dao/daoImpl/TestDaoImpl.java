package com.example.yadaun.dao.daoImpl;

import com.example.yadaun.dao.TestDao;
import com.example.yadaun.entity.Test;
import com.example.yadaun.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestDaoImpl implements TestDao {

    @Override
    public boolean addTest(Test test) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(test);
            tx.commit();
            session.close();
            isAdded = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateTest(Test test) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(test);
            tx.commit();
            session.close();
            isUpdated = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteTest(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Test test = session.load(Test.class, id);
            session.delete(test);
            tx.commit();
            session.close();
            isDeleted = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<Test> showTest() {
        List<Test> tests = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Test> cr = cb.createQuery(Test.class);
            Root<Test> root = cr.from(Test.class);
            cr.select(root);
            tests = session.createQuery(cr).getResultList();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return tests;
    }

    @Override
    public Test findTestById(int id) {
        Test test = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Test> cr = cb.createQuery(Test.class);
            Root<Test> root = cr.from(Test.class);
            cr.select(root).where(cb.equal(root.get("testId"), id));
            test = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return test;
    }

    @Override
    public Test findTestByName(String name) {
        Test test = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Test> cr = cb.createQuery(Test.class);
            Root<Test> root = cr.from(Test.class);
            cr.select(root).where(cb.equal(root.get("name"), name));
            test = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return test;
    }
}
