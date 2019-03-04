package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class DeleteProjectServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteProjectServlet doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteProjectServlet doGet()");
        final String id = request.getParameter(("id"));
        final ProjectService projectService = ServiceLocator.getProjectService();
        projectService.deleteById(id);
        response.sendRedirect("projects");
    }

}
