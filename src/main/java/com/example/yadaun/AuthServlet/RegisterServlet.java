package com.example.yadaun.AuthServlet;

import java.io.*;
import java.util.Locale;

import com.example.yadaun.dao.daoImpl.UserDaoImpl;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/registeer.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "user";

        User user = new User();
        user.setLogin(username);
        user.setPassword(password);
        user.setRole(role);

        Person person = new Person();
        person.setUser(user);
        user.setPerson(person);

        UserDaoImpl userDao = new UserDaoImpl();

        boolean isAdded = userDao.addUser(user);

        if (isAdded) {
            response.sendRedirect("/authentication");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            getServletContext().getRequestDispatcher("/registeer.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}