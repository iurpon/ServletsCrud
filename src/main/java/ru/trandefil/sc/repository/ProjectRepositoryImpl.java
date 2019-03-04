package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.model.Project;

import java.util.*;

public class ProjectRepositoryImpl implements ProjectRepository {

    private ProjectRepositoryImpl(){}

    private Map<String, Project> projectMap = new HashMap<>();

    {init();}

    private void init(){
            String id1 = UUID.randomUUID().toString();
            String id2 = UUID.randomUUID().toString();
            projectMap.put(id1,new Project(id1,"project1"));
            projectMap.put(id2,new Project(id2,"project2"));
    }

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
