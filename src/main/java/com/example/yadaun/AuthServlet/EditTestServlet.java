package com.example.yadaun.AuthServlet;
import com.example.yadaun.dao.UserDao;
import com.example.yadaun.dao.daoImpl.TestDaoImpl;
import com.example.yadaun.dao.daoImpl.UserDaoImpl;
import com.example.yadaun.entity.Test;
import com.example.yadaun.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/edit")
public class EditTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение данных теста для редактирования (замените этот код на свою логику получения)
        Test test = new Test();
        // Получение параметров из формы
        test.setName(request.getParameter("name_test"));

        for (int i = 1; i <= 5; i++) {
            String question = request.getParameter("question" + i);
            String option1 = request.getParameter("option" + i + "_1");
            String option2 = request.getParameter("option" + i + "_2");
            String option3 = request.getParameter("option" + i + "_3");
            int answer = Integer.parseInt(request.getParameter("answer" + i));

            switch (i) {
                case 1:
                    test.setQuestion1(question);
                    test.setQuestion1Option1(option1);
                    test.setQuestion1Option2(option2);
                    test.setQuestion1Option3(option3);
                    test.setAnswer1(answer);
                    break;
                case 2:
                    test.setQuestion2(question);
                    test.setQuestion2Option1(option1);
                    test.setQuestion2Option2(option2);
                    test.setQuestion2Option3(option3);
                    test.setAnswer2(answer);
                    break;
                case 3:
                    test.setQuestion3(question);
                    test.setQuestion3Option1(option1);
                    test.setQuestion3Option2(option2);
                    test.setQuestion3Option3(option3);
                    test.setAnswer3(answer);
                    break;
                case 4:
                    test.setQuestion4(question);
                    test.setQuestion4Option1(option1);
                    test.setQuestion4Option2(option2);
                    test.setQuestion4Option3(option3);
                    test.setAnswer4(answer);
                    break;
                case 5:
                    test.setQuestion5(question);
                    test.setQuestion5Option1(option1);
                    test.setQuestion5Option2(option2);
                    test.setQuestion5Option3(option3);
                    test.setAnswer5(answer);
                    break;
            }
        }

        TestDaoImpl testDao = new TestDaoImpl();
        testDao.updateTest(test);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение данных теста для редактирования (замените этот код на свою логику получения)
        String id = request.getParameter("id");
        String testName = "Test Name";
        TestDaoImpl testDao = new TestDaoImpl();
        Test test = testDao.findTestById(Integer.parseInt(id));
        // Замените следующий блок кода на свою логику получения данных для каждого вопроса
        request.setAttribute("test", test);
        // Перенаправление на страницу редактирования
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}