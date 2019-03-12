package ru.trandefil.sc.filter;

import ru.trandefil.sc.Main;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

//@WebFilter("/*")
public class SecurityFilter implements Filter {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("============================================= Security Filter init()");
        Main.main(null);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.info("-------------------------------- filter starts ");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        // Информация пользователя сохранена в Session
        // (После успешного входа в систему).
        User loginUser = SessionUtil.getLoginUser(request.getSession());
        logger.info("----------------------------- user READY ? : " + loginUser);

        if (servletPath.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
        if (loginUser == null) {
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
