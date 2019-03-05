package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TaskListServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("TAskListServlet doGet()");
        final TaskService taskService = ServiceLocator.getTaskService();
        List<Task> all = taskService.getAll();
        request.setAttribute("tasks",all);
        request.getRequestDispatcher("/WEB-INF/view/task-list.jsp").forward(request,response);
    }

}
