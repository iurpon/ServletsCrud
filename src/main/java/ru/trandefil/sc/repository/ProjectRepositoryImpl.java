package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.model.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepositoryImpl implements ProjectRepository {

    private ProjectRepositoryImpl(){}

    private Map<String, Project> projectMap = new HashMap<>();

    @Override
    public Project save(Project project) {
        return projectMap.put(project.getId(),project);
    }

    @Override
    public Project getById(String id) {
        return projectMap.get(id);
    }

    @Override
    public void delete(Project project) {
        projectMap.remove(project.getId());
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projectMap.values());
    }

    static class RepositoryHolder{
        static ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
    }

    public static ProjectRepository getProjectRepository(){
        return RepositoryHolder.projectRepository;
    }

}
