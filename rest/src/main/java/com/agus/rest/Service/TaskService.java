package com.agus.rest.Service;

import com.agus.rest.Model.Task;
import com.agus.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TodoRepository todoRepository;

    public String holaMundo(){
        return "Hola Mundo!";
    }

    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    public Task saveTask(Task task){
        return todoRepository.save(task);
    }

    public boolean updateTask(long id, Task task){
        try {
            Task updatedTask = todoRepository.findById(id).get();
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            return true;
            //return todoRepository.save(updatedTask);
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteTask(long id, Task task){
        try{
            todoRepository.deleteById(id);
            return true;
        }catch(Exception err){
        return false;
        }
    }
}
