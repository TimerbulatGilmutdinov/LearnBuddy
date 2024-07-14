package ru.kpfu.itis.semestrproject.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/profile", "/profile/subjects"})
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/learnBuddy/profile")) {
            req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
        }
        if (req.getRequestURI().equals("/learnBuddy/profile/subjects")) {
            req.getRequestDispatcher("/WEB-INF/views/profileSubjects.jsp").forward(req, resp);
        }
    }
}
