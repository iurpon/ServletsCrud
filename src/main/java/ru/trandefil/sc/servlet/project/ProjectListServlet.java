package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/projects")
public class ProjectListServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("ProjectLIstServlet doGet");
        List<Project> list = ServiceLocator.getProjectService().getAll();
        req.setAttribute("items", list);
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/view/project-list.jsp").forward(req, resp);
    }

}
