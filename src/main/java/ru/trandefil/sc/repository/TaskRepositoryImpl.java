package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.model.Task;

import java.util.*;

public class TaskRepositoryImpl implements TaskRepository{

    private TaskRepositoryImpl(){

    }

    static class TaskRepositoryHolder{
        static TaskRepository taskRepository = new TaskRepositoryImpl();
    }

    public static TaskRepository getTaskRepository(){
        return TaskRepositoryHolder.taskRepository;
    }

    private Map<String, Task> taskMap = new HashMap<>();

    @Override
    public Task save(Task task) {
        if(task.isNew()){
            task.setId(UUID.randomUUID().toString());
        }
        return taskMap.put(task.getId(),task);
    }

    @Override
    public Task getById(String id) {
        return taskMap.get(id);
    }

    @Override
    public void delete(Task task) {
        taskMap.remove(task.getId());
    }

    @Override
    public void deletById(String id) {
        taskMap.remove(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(taskMap.values());
    }
}
