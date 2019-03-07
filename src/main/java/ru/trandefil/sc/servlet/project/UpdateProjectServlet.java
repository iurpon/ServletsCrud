package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/updateProject")
public class UpdateProjectServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("UpdateProjectServlet doPost()");
        final String id = request.getParameter("id");
        final String name = request.getParameter("name");
        if(name.isEmpty() || name == null){
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String description = request.getParameter("description");
        if(name.isEmpty()){
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final Project project = new Project(id, name, description);
        final ProjectService projectService = ServiceLocator.getProjectService();
        projectService.save(project);
        final TaskService taskService = ServiceLocator.getTaskService();
        final List<Task> tasks = taskService.getAll();
        tasks.forEach(task -> {
            if(task.getProject().getId().equals(id)){
                task.getProject().setName(name);
            }
        });
        response.sendRedirect("projects");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("UpdateProjectServlet doGet()");
        final String id = request.getParameter("id");
        final ProjectService projectService = ServiceLocator.getProjectService();
        final Project project = projectService.getById(id);
        request.setAttribute("project",project);
//        request.getRequestDispatcher("/WEB-INF/view/projectUpdateForm.jsp").forward(request,response);
        request.setAttribute("action","update");
        request.getRequestDispatcher("/WEB-INF/view/editProject.jsp").forward(request,response);
    }

}
