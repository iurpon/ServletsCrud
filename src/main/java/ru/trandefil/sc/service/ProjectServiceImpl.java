package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.model.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private static ProjectServiceImpl projectService = null;

    private ProjectRepository projectRepository;

    private ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(@NonNull final Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(@NonNull final String id) {
        return projectRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    public static ProjectService getProjectService(ProjectRepository projectRepository){
        if(projectService == null){
            projectService = new ProjectServiceImpl(projectRepository);
        }
        return projectService;
    }

    @Override
    public void deleteById(@NonNull final String id) {
        projectRepository.deletById(id);
    }

}
