package ru.trandefil.sc.api;

import ru.trandefil.sc.repository.ProjectRepositoryImpl;
import ru.trandefil.sc.service.ProjectServiceImpl;

public class ServiceLocator {

    public static ProjectService getProjectService(){
        ProjectRepository projectRepository = ProjectRepositoryImpl.getProjectRepository();
        ProjectService projectService = ProjectServiceImpl.getProjectService(projectRepository);
        return projectService;
    }

}
