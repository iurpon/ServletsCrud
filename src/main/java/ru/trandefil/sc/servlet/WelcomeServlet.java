package ru.trandefil.sc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class WelcomeServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("welcome servlet doGet-------------------------");
        req.getRequestDispatcher("/WEB-INF/view/hello.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.info("welcome servlet init()---------------------------");
    }

}
