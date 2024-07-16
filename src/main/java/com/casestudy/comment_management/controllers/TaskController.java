package com.casestudy.comment_management.controllers;

import com.casestudy.comment_management.business.abstracts.TaskService;
import com.casestudy.comment_management.business.dtos.request.task.CreateTaskRequest;
import com.casestudy.comment_management.business.dtos.response.task.CreatedTaskResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetAllTasksResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetTaskResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tasks")
public class TaskController {

    private TaskService taskService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTaskResponse add(@Valid @RequestBody CreateTaskRequest request){
        return taskService.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetTaskResponse getTaskById(@PathVariable int id){
        return taskService.getById(id);
    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTasksResponse> getTasks(){
        return taskService.getAllTasks();
    }

}
