
package com.example.yadaun.AuthServlet;

import com.example.yadaun.dao.daoImpl.PersonDaoImpl;
import com.example.yadaun.dao.daoImpl.TestDaoImpl;
import com.example.yadaun.dao.daoImpl.TestResultDaoImpl;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.Test;

import java.util.ArrayList;
import java.util.Enumeration;


import java.io.*;
import java.util.List;
import java.util.Map;

import com.example.yadaun.entity.TestResult;
import com.example.yadaun.entity.User;
import com.example.yadaun.sessionFactory.SessionFactoryImpl;
import com.example.yadaun.testServlet.TestSerializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@WebServlet(name = "testResultServlet", value = "/showTestResult")
public class TestResultServlet extends HttpServlet {


    public List<TestResult> findTestResultsByPersonId(int personId) {
        List<TestResult> testResults = new ArrayList<>();
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TestResult> cr = cb.createQuery(TestResult.class);
            Root<TestResult> root = cr.from(TestResult.class);
            cr.select(root).where(cb.equal(root.get("person").get("personId"), personId));
            testResults = session.createQuery(cr).getResultList();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return testResults;
    }

    public int personByUserId(int userId){
        Session sessionx = SessionFactoryImpl.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = sessionx.getCriteriaBuilder();

        // Создание CriteriaQuery
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("user"), userId));

        // Создание запроса на основе CriteriaQuery
        Query<Person> query = sessionx.createQuery(criteriaQuery);

        // Выполнение запроса и получение результата
        Person person = query.uniqueResult();

        return person.getPersonId();
    }
    private TestDaoImpl testDaoImpl = new TestDaoImpl();
    private PersonDaoImpl personDao = new PersonDaoImpl();
    private TestResultDaoImpl testDaoResultImpl = new TestResultDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        request.setAttribute("testsRes", findTestResultsByPersonId(
                personByUserId(user.getUserId())));// Сохранение списка тестов в атрибуте запроса

        // Перенаправление на JSP-страницу для отображения списка тестов
        request.getRequestDispatcher("/testResult.jsp").forward(request, response);
    }
}