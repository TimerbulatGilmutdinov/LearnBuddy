package ru.kpfu.itis.semestrproject.listeners;

import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepositoryJdbcImpl;
import ru.kpfu.itis.semestrproject.repositories.UsersRepositoryJdbcImpl;
import ru.kpfu.itis.semestrproject.services.AuthService;
import ru.kpfu.itis.semestrproject.services.SecurityService;
import ru.kpfu.itis.semestrproject.services.UserSubjectService;
import ru.kpfu.itis.semestrproject.utils.SimpleDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Loader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("userSubjectRepository", new UserSubjectRepositoryJdbcImpl(new SimpleDataSource()));
        sce.getServletContext().setAttribute("usersRepository", new UsersRepositoryJdbcImpl(new SimpleDataSource()));
        sce.getServletContext().setAttribute("authService", new AuthService(new UsersRepositoryJdbcImpl(new SimpleDataSource())));
        sce.getServletContext().setAttribute("securityService", new SecurityService(new UsersRepositoryJdbcImpl(new SimpleDataSource()), new UserSubjectRepositoryJdbcImpl(new SimpleDataSource())));
        sce.getServletContext().setAttribute("userSubjectService", new UserSubjectService(new UsersRepositoryJdbcImpl(new SimpleDataSource()), new UserSubjectRepositoryJdbcImpl(new SimpleDataSource())));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
