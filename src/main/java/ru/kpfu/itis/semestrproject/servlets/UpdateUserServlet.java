package ru.kpfu.itis.semestrproject.servlets;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;
import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;
import ru.kpfu.itis.semestrproject.services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/update", "/update/subjects"})
public class UpdateUserServlet extends HttpServlet {
    private UsersRepository usersRepository;
    private SecurityService securityService;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public void init() {
        userSubjectRepository = (UserSubjectRepository) getServletContext().getAttribute("userSubjectRepository");
        securityService = (SecurityService) getServletContext().getAttribute("securityService");
        usersRepository = (UsersRepository) getServletContext().getAttribute("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/learnBuddy/update")) {
            req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
        }
        if (req.getRequestURI().equals("/learnBuddy/update/subjects")) {
            req.getRequestDispatcher("/WEB-INF/views/updateSubjects.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/learnBuddy/update")) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            String name = req.getParameter("name").equals("") ? user.getName() : req.getParameter("name");
            String surname = req.getParameter("surname").equals("") ? user.getSurname() : req.getParameter("surname");
            String passwordHash = req.getParameter("password").equals("") ? user.getPasswordHash() : securityService.getHash(req.getParameter("password"));
            String country = req.getParameter("country").equals("") ? user.getCountry() : req.getParameter("country");
            String city = req.getParameter("city").equals("") ? user.getCity() : req.getParameter("city");

            User updatedUser = new User(user.getId(), name, surname, user.getEmail(), passwordHash, user.getBirthdate(), user.getGender(), country, city, user.isAdmin());

            usersRepository.updateUser(updatedUser);
            req.getSession().setAttribute("user", updatedUser);
            resp.sendRedirect(req.getContextPath() + "/profile");
        }
        if (req.getRequestURI().equals("/learnBuddy/update/subjects")) {
            HttpSession session = req.getSession();
            UserSubject userSubject = (UserSubject) session.getAttribute("userSubject");

            boolean maths = req.getParameter("maths") != null && Boolean.parseBoolean(req.getParameter("maths"));
            boolean physics = req.getParameter("physics") != null && Boolean.parseBoolean(req.getParameter("physics"));
            boolean programming = req.getParameter("programming") != null && Boolean.parseBoolean(req.getParameter("programming"));
            boolean englishLanguage = req.getParameter("englishLanguage") != null && Boolean.parseBoolean(req.getParameter("englishLanguage"));
            boolean history = req.getParameter("history") != null && Boolean.parseBoolean(req.getParameter("history"));
            boolean economics = req.getParameter("economics") != null && Boolean.parseBoolean(req.getParameter("economics"));
            boolean law = req.getParameter("law") != null && Boolean.parseBoolean(req.getParameter("law"));

            UserSubject updatedUserSubject = new UserSubject(userSubject.getUserId(), maths, physics, englishLanguage, programming, history, economics, law);
            userSubjectRepository.setSubjectValuesToUser(updatedUserSubject);
            req.getSession().setAttribute("userSubject", updatedUserSubject);
            resp.sendRedirect(req.getContextPath() + "/profile");
        }
    }
}
