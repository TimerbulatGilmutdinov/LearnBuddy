package ru.kpfu.itis.semestrproject.servlets;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;
import ru.kpfu.itis.semestrproject.services.UserSubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchBySubjectServlet extends HttpServlet {
    private UserSubjectService userSubjectService;

    @Override
    public void init() {
        userSubjectService = (UserSubjectService) getServletContext().getAttribute("userSubjectService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String subjectName = req.getParameter("subjectName");
        List<User> foundUsersBySubjectName = userSubjectService.findAllUsersBySubject(subjectName);
        session.setAttribute("foundUsersBySubjectName", foundUsersBySubjectName);
        resp.sendRedirect(req.getContextPath() + "/search");
    }
}
