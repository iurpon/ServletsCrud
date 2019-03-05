package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.api.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class DeleteTaskServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteTaskServlet doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteTaskServlet doGet()");
        final String id = request.getParameter("id");
        final TaskService taskService = ServiceLocator.getTaskService();
        taskService.deletById(id);
        response.sendRedirect("tasks");
    }
}
