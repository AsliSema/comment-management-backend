package com.casestudy.comment_management.business.abstracts;

import com.casestudy.comment_management.business.dtos.request.task.CreateTaskRequest;
import com.casestudy.comment_management.business.dtos.response.task.CreatedTaskResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetAllTasksResponse;
import com.casestudy.comment_management.business.dtos.response.task.GetTaskResponse;
import com.casestudy.comment_management.entities.concretes.Task;

import java.util.List;

public interface TaskService {
    CreatedTaskResponse create(CreateTaskRequest request);

    GetTaskResponse getById(int id);

    List<GetAllTasksResponse> getAllTasks();

    Task getTaskById(int id);

}
