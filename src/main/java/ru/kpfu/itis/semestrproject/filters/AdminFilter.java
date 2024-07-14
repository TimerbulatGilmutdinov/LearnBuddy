package ru.kpfu.itis.semestrproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/adminPanel")
public class AdminFilter extends HttpFilter {
    private final String[] adminPages = {"/adminPanel"};

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String contextPath = request.getContextPath();
        boolean isAdmin = false;
        if (session != null) {
            isAdmin = session.getAttribute("isAdmin") != null;
        }
        boolean isAdminPage = false;
        for (String page : adminPages) {
            isAdminPage |= request.getRequestURI().equals(contextPath + page);
        }
        if (isAdminPage && !isAdmin) {
            response.sendRedirect(contextPath + "/profile");
        } else {
            chain.doFilter(request, response);
        }
    }
}
