package com.example.teachertask.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/createTask")   //isleyir
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @GetMapping("/allTask")  //isleyir
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @DeleteMapping("/removeALlTask")
    public void deleteAllTasks() {
        taskService.removeAllTask();
    }
    @DeleteMapping("/remove/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }
    @PutMapping("/updateTask/{taskId}")
    public Task updateTask(@RequestBody Task task,@PathVariable Long taskId) {
        return taskService.updateTask(task,taskId);
    }
}
