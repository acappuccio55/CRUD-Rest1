package com.agus.rest.Controller;

import com.agus.rest.Model.Task;
import com.agus.rest.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/")
    public String holaMundo(){
        return taskService.home();
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return this.taskService.getTasks();
    }

    @PostMapping(value = "/savetask")
    public Task saveTask(@RequestBody Task task){
        return this.taskService.saveTask(task);
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        boolean ok = this.taskService.updateTask(id, task);
        if (ok){
            taskService.updateTask(id, task);
            return "Task updated";
        }else{
            return "Task not found";
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id, @RequestBody Task task){
        boolean ok = this.taskService.deleteTask(id, task);
        if (ok){
            return "Task deleted"; //Code 200 http
        }else{
            return "Task not found"; //Code 404 http
        }
    }

}
