package com.example.yadaun.AuthServlet;


import java.io.*;
import java.util.Locale;

import com.example.yadaun.dao.daoImpl.UserDaoImpl;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "changeLocaleServlet", value = "/changeLocale")
public class ChangeLocaleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localeParam = request.getParameter("locale");

        if (localeParam != null) {
            Locale locale = new Locale(localeParam);

            // Save the selected locale in the session or other appropriate way for your application
            // For example, you can save the locale as a session attribute
            request.getSession().setAttribute("currentLocale", locale);
        } else {
            // Handle the situation when the "locale" parameter is not provided
            // You can use a default locale or display an error message
        }

        // Redirect to the same page or another page
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localeParam = request.getParameter("locale");

        if (localeParam != null) {
            Locale locale = new Locale(localeParam);

            // Save the selected locale in the session or other appropriate way for your application
            // For example, you can save the locale as a session attribute
            request.getSession().setAttribute("currentLocale", locale);
        } else {
            // Handle the situation when the "locale" parameter is not provided
            // You can use a default locale or display an error message
        }

        // Redirect to the same page or another page
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }
}