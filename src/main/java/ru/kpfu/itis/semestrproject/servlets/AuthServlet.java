package ru.kpfu.itis.semestrproject.servlets;

import com.twmacinta.util.MD5;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;
import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;
import ru.kpfu.itis.semestrproject.services.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {
    private AuthService authService;
    private UsersRepository usersRepository;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public void init() {
        this.userSubjectRepository = (UserSubjectRepository) getServletContext().getAttribute("userSubjectRepository");
        this.usersRepository = (UsersRepository)getServletContext().getAttribute("usersRepository");
        this.authService = (AuthService) getServletContext().getAttribute("authService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        MD5 md5 = new MD5();
        md5.Update(password);
        String passwordHash = md5.asHex();

        if (authService.userLogIn(email, passwordHash, req)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("isAuthenticated",true);
            User user = usersRepository.findByEmail(email);
            UserSubject userSubject = userSubjectRepository.findByUserId(user.getId());
            session.setAttribute("user",user);
            session.setAttribute("isAdmin", user.isAdmin());
            session.setAttribute("userSubject",userSubject);
            resp.sendRedirect((req.getContextPath()) + "/profile");
        } else {
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
