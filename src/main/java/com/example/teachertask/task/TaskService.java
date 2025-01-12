package com.example.teachertask.task;

import com.example.teachertask.allusers.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void removeAllTask() {
        taskRepository.deleteAll();

    }

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }


    public Task updateTask(Task task, Long taskId) {
        Task taskToUpdate = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStartDate(task.getStartDate());
        taskToUpdate.setEndDate(task.getEndDate());
        return taskRepository.save(taskToUpdate);
    }
}
