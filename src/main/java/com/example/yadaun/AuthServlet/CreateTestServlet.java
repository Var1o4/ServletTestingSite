package com.example.yadaun.AuthServlet;

import com.example.yadaun.dao.TestDao;
import com.example.yadaun.dao.daoImpl.TestDaoImpl;
import com.example.yadaun.entity.Test;
import com.example.yadaun.sessionFactory.SessionFactoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/createTest")
public class CreateTestServlet extends HttpServlet {
    private TestDaoImpl testDao = new TestDaoImpl();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          request.getRequestDispatcher("/create_test.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Test test = new Test();
        // Получение параметров из формы
        test.setName(request.getParameter("name_test"));

        test.setQuestion1(request.getParameter("question1"));
        test.setQuestion1Option1(request.getParameter("option1_1"));
        test.setQuestion1Option2(request.getParameter("option1_2"));
        test.setQuestion1Option3(request.getParameter("option1_3"));

        test.setQuestion2(request.getParameter("question2"));
        test.setQuestion2Option1(request.getParameter("option2_1"));
        test.setQuestion2Option2(request.getParameter("option2_2"));
        test.setQuestion2Option3(request.getParameter("option2_3"));

        test.setQuestion3(request.getParameter("question3"));
        test.setQuestion3Option1(request.getParameter("option3_1"));
        test.setQuestion3Option2(request.getParameter("option3_2"));
        test.setQuestion3Option3(request.getParameter("option3_3"));

        test.setQuestion4(request.getParameter("question4"));
        test.setQuestion4Option1(request.getParameter("option4_1"));
        test.setQuestion4Option2(request.getParameter("option4_2"));
        test.setQuestion4Option3(request.getParameter("option4_3"));

        test.setQuestion5(request.getParameter("question5"));
        test.setQuestion5Option1(request.getParameter("option5_1"));
        test.setQuestion5Option2(request.getParameter("option5_2"));
        test.setQuestion5Option3(request.getParameter("option5_3"));
        test.setAnswer1(Integer.valueOf(request.getParameter("answer1")));
        test.setAnswer2(Integer.valueOf(request.getParameter("answer2")));
        test.setAnswer3(Integer.valueOf(request.getParameter("answer3")));
        test.setAnswer4(Integer.valueOf(request.getParameter("answer4")));
        test.setAnswer5(Integer.valueOf(request.getParameter("answer5")));
        boolean isAdded = testDao.addTest(test);
        if (isAdded) {
            response.sendRedirect("/test");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            getServletContext().getRequestDispatcher("/create_test.jsp").forward(request, response);
        }

    }
}