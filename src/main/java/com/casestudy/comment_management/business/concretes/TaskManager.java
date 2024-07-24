package com.casestudy.comment_management.business.concretes;

import com.casestudy.comment_management.business.abstracts.TaskService;
import com.casestudy.comment_management.business.dtos.request.task.CreateTaskRequest;
import com.casestudy.comment_management.business.dtos.response.task.CreatedTaskResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetAllTasksResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetTaskResponse;
import com.casestudy.comment_management.business.rules.TaskBusinessRules;
import com.casestudy.comment_management.core.utilities.mapping.ModelMapperService;
import com.casestudy.comment_management.dataAccess.TaskRepository;
import com.casestudy.comment_management.entities.concretes.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskManager implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapperService modelMapperService;
    private TaskBusinessRules taskBusinessRules;

    @Override
    public CreatedTaskResponse create(CreateTaskRequest request) {
        Task task = this.modelMapperService.forRequest().map(request, Task.class);
        task.setCreatedDate(LocalDateTime.now());
        Task createdTask = this.taskRepository.save(task);
        CreatedTaskResponse createdTaskResponse = this.modelMapperService.forResponse().map(createdTask, CreatedTaskResponse.class);
        return createdTaskResponse;
    }

    @Override
    public GetTaskResponse getById(int id) {
        taskBusinessRules.checkIfTaskExist(id);

        Task task = this.taskRepository.findById(id);
        GetTaskResponse taskResponse = this.modelMapperService.forResponse().map(task, GetTaskResponse.class);
        return taskResponse;

    }

    @Override
    public List<GetAllTasksResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        tasks.sort(Comparator.comparing(Task::getCreatedDate).reversed());

        List<GetAllTasksResponse>  response = tasks.stream().map(task -> modelMapperService.forResponse().map(task, GetAllTasksResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public Task getTaskById(int id) {
        Task task = this.taskRepository.findById(id);
        return task;
    }

}
