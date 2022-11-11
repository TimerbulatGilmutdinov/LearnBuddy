package ru.kpfu.itis.semestrproject.services;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class AuthService {
    private final UsersRepository usersRepository;

    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean userLogIn(String email, String hash, HttpServletRequest request) {
        email = email.toLowerCase();
        String passwordHash = String.valueOf(usersRepository.findHashByEmail(email));
        if (!(usersRepository.findByEmail(email)==null)) {
            if (passwordHash.equals(hash)) {
                User user = usersRepository.findByEmail(email);
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("isAuthenticated", true);
                return true;
            }
        }
        return false;
    }
}
