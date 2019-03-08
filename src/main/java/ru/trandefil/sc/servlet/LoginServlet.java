package ru.trandefil.sc.servlet;

import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("LoginServlet doGet()");
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("LoginServlet doPost()");
        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        final User loginUser = userService.getLoggedUser(name, password);
        System.out.println(loginUser);
        if (loginUser == null) {
            req.setAttribute("message", "Bad login. Try again.");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            return;
        }
        final HttpSession httpSession = req.getSession();
        httpSession.setAttribute("loginUser", loginUser);
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

}
