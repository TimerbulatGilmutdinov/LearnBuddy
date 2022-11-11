package ru.kpfu.itis.semestrproject.servlets;

import com.twmacinta.util.MD5;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UsersRepository usersRepository;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public void init() {
        this.usersRepository = (UsersRepository) getServletContext().getAttribute("usersRepository");
        this.userSubjectRepository = (UserSubjectRepository) getServletContext().getAttribute("userSubjectRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");
        String birthdate = req.getParameter("birthdate");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String city = req.getParameter("city");

        MD5 md5 = new MD5();
        md5.Update(password);
        String passwordHash = md5.asHex();

        if (usersRepository.findByEmail(email)==null) {
            User user = new User(name, surname, email, passwordHash, birthdate, gender, country, city);
            try {
                if (usersRepository.registerUser(user)) {
                    req.setAttribute("user",user);
                    Long id = usersRepository.findByEmail(email).getId();
                    user.setId(id);
                    userSubjectRepository.setDefaultSubjectValuesToUser(user);
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            writer.println("User with this email already exists");
        }
    }
}
