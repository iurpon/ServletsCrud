package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private static TaskService taskService = null;

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static TaskService getTaskService(TaskRepository taskRepository) {
        if (taskService == null) {
            return new TaskServiceImpl(taskRepository);
        }
        return taskService;
    }

    @Override
    public Task save(@NonNull final Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(@NonNull final String id) {
        return taskRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deletById(@NonNull final String id) {
        taskRepository.deletById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

}
