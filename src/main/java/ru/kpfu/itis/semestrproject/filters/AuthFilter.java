package ru.kpfu.itis.semestrproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    private final String[] pages = {"/profile","/profile/subjects", "/update", "/update/subjects", "/logout", "/delete","/feed","/adminPanel","/search"};

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String contextPath = request.getContextPath();
        boolean isPrivatePage = false;
        for (String page : pages) {
            isPrivatePage |= request.getRequestURI().equals(request.getContextPath() + page);
        }
        boolean isStaticResource = request.getRequestURI().startsWith(contextPath + "/static/") ||
                request.getRequestURI().startsWith(contextPath + "/js/");
        boolean isAuthenticated = false;
        if (session != null) {
            isAuthenticated = session.getAttribute("isAuthenticated") != null;
        }
        if (!isAuthenticated && isPrivatePage && !isStaticResource) {
            response.sendRedirect(contextPath + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
