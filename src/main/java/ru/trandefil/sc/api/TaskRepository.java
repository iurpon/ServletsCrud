package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Project;

public interface TaskRepository {

    Project save(Project project);

    Project getById(String id);

    void delete(Project project);

}
