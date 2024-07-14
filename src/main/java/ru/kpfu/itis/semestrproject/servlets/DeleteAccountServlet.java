package ru.kpfu.itis.semestrproject.servlets;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteAccountServlet extends HttpServlet {
    private SecurityService securityService;

    @Override
    public void init() {
        securityService = (SecurityService) getServletContext().getAttribute("securityService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        session.removeAttribute("isAuthenticated");
        session.removeAttribute("user");
        securityService.deleteUser(user);
        resp.sendRedirect(req.getContextPath() + "/welcome");
    }
}
