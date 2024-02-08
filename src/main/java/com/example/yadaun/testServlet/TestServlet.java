package com.example.yadaun.testServlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class TestServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "TestServlet!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        // Далее можно выполнить необходимую обработку данных

        // Например, сохранить данные в базе данных или передать их другому компоненту для дальнейшей обработки

        // Отправить ответ клиенту
        response.sendRedirect("/testing?"+"name="+name+"&"+"age="+String.valueOf(age)+"&"+"gender="+gender);
        System.out.println(name+gender);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       getServletContext().getRequestDispatcher("/auth.jsp").forward(request, response);
    }

    public void destroy() {
    }
}