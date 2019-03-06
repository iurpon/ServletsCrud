package ru.trandefil.sc.api;

import ru.trandefil.sc.repository.ProjectRepositoryImpl;
import ru.trandefil.sc.repository.TaskRepositoryImpl;
import ru.trandefil.sc.repository.UserRepositoryImpl;
import ru.trandefil.sc.service.ProjectServiceImpl;
import ru.trandefil.sc.service.TaskServiceImpl;
import ru.trandefil.sc.service.UserServiceImpl;

public class ServiceLocator {

    public static ProjectService getProjectService(){
        ProjectRepository projectRepository = ProjectRepositoryImpl.getProjectRepository();
        ProjectService projectService = ProjectServiceImpl.getProjectService(projectRepository);
        return projectService;
    }

    public static TaskService getTaskService(){
        TaskRepository taskRepository = TaskRepositoryImpl.getTaskRepository();
        TaskService taskService = TaskServiceImpl.getTaskService(taskRepository);
        return taskService;
    }

    public static UserService getUserService(){
        UserRepository userRepository = UserRepositoryImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance(userRepository);
        return userService;
    }

}
