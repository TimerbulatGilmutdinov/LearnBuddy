package ru.kpfu.itis.semestrproject.servlets;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;
import ru.kpfu.itis.semestrproject.services.UserSubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adminPanel")
public class AdminPanelServlet extends HttpServlet {
    private UsersRepository usersRepository;

    @Override
    public void init() {
        usersRepository = (UsersRepository) getServletContext().getAttribute("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/adminPanel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User foundUser = usersRepository.findByEmail(email);
        req.getSession().setAttribute("foundUser", foundUser);

        resp.sendRedirect(req.getContextPath() + "/adminPanel");
    }
}
