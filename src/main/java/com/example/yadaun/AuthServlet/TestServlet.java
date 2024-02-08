// TestServlet.java
package com.example.yadaun.AuthServlet;

import com.example.yadaun.dao.daoImpl.TestDaoImpl;
import com.example.yadaun.dao.daoImpl.TestResultDaoImpl;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.Test;

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
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@WebServlet(name = "testServlet", value = "/test")
public class TestServlet extends HttpServlet {

    private TestDaoImpl testDaoImpl = new TestDaoImpl();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение параметров из запроса
        String id = request.getParameter("id");

        // Удаление данных из источника данных или базы данных
        // Здесь предполагается, что вы используете какой-то сервис или слой доступа к данным для выполнения операции удаления
        testDaoImpl.deleteTest(Integer.parseInt(id));
        // Обновление состояния или отображения на веб-странице
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        TestDaoImpl testDao = new TestDaoImpl();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String fafo = request.getParameter("serializedTest");
        Test test = testDao.findTestById(Integer.parseInt(fafo));
        TestResult testResult = new TestResult();
        int totalScore = 0;
        int i = 0; // Итерация по параметрам формы
        for (String paramName : parameterMap.keySet()) {
            String[] paramValues = parameterMap.get(paramName);
            // Обработка значений параметра
            for (String paramValue : paramValues) {
                // Ваш код обработки значения поля формы
                System.out.println("Parameter: " + paramName + ", Value: " + paramValue);

                // Вызов соответствующей функции getAnswer() в зависимости от paramName
                switch (paramName) {
                    case "question1Options":
                        if (Integer.parseInt(paramValue) == test.getAnswer1()) {
                            totalScore += 1;
                        }
                        testResult.setFirst_answer(Integer.parseInt(paramValue) == test.getAnswer1());
                        break;
                    case "question2Options":
                        if (Integer.parseInt(paramValue) == test.getAnswer2()) {
                            totalScore += 1;
                        }
                        testResult.setSecond_answer(Integer.parseInt(paramValue) == test.getAnswer2());
                        break;
                    case "question3Options":
                        if (Integer.parseInt(paramValue) == test.getAnswer3()) {
                            totalScore += 1;
                        }
                        testResult.setThreeth_answer(Integer.parseInt(paramValue) == test.getAnswer3());
                        break;
                    case "question4Options":
                        if (Integer.parseInt(paramValue) == test.getAnswer4()) {
                            totalScore += 1;
                        }
                        testResult.setFourth_answer(Integer.parseInt(paramValue) == test.getAnswer4());
                        break;
                    case "question5Options":
                        if (Integer.parseInt(paramValue) == test.getAnswer5()) {
                            totalScore += 1;
                        }
                        testResult.setFourth_answer(Integer.parseInt(paramValue) == test.getAnswer5());

                        break;

                }
            }
        }
        testResult.setAll_answer("Вы выполнили на: " + (totalScore * 100 / 5) +"%");
        TestResultDaoImpl testResultDao = new TestResultDaoImpl();

        Session sessionx = SessionFactoryImpl.getSessionFactory().openSession();

        CriteriaBuilder criteriaBuilder = sessionx.getCriteriaBuilder();

        // Создание CriteriaQuery
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("user"), user.getUserId()));

        // Создание запроса на основе CriteriaQuery
        Query<Person> query = sessionx.createQuery(criteriaQuery);

        // Выполнение запроса и получение результата
        Person person = query.uniqueResult();

        testResult.setTest(test);
        // Проверка результата
        if (person != null) {
            // Объект Person найден
            System.out.println("Person: " + person);
            testResult.setPerson(person);
            testResultDao.addTestResult(testResult);
        } else {
            // Объект Person не найден
            System.out.println("Объект Person не найден");
        }
        List<Test> tests = testDaoImpl.showTest(); // Получение списка тестов

        request.setAttribute("tests", tests); // Сохранение списка тестов в атрибуте запроса

        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Test> tests = testDaoImpl.showTest(); // Получение списка тестов

        request.setAttribute("tests", tests); // Сохранение списка тестов в атрибуте запроса

        // Перенаправление на JSP-страницу для отображения списка тестов
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }
}