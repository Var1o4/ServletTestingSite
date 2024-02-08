package com.example.yadaun.AuthServlet;

import com.example.yadaun.dao.UserDao;
import com.example.yadaun.dao.daoImpl.UserDaoImpl;
import com.example.yadaun.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/authentication")
public class AuthServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl(); // Инициализируем объект UserDao
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Проверяем введенные данные
        User user = userDao.findUserByLogin(username);
        if (user != null && user.getPassword().equals(password)) {
            // Если данные верны, сохраняем пользователя в сессии
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Перенаправляем на защищенную страницу
            response.sendRedirect("/test");
        } else {
            // Если данные неверны, перенаправляем обратно на страницу авторизации с сообщением об ошибке
            response.sendRedirect("/auth.jsp?error=1");
        }
    }
}