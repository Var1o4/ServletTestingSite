package com.example.yadaun;

import java.io.*;
import java.util.Locale;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Locale locale = new Locale("de");

        // Сохранение выбранной локали в сессии или другим способом, подходящим для вашего приложения
        // Например, можно сохранить локаль в атрибуте сессии
        request.getSession().setAttribute("currentLocale", locale);

        response.sendRedirect("/authentication");
    }

    public void destroy() {
    }
}