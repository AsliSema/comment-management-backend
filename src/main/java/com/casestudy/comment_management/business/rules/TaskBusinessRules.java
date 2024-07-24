package com.casestudy.comment_management.business.rules;

import com.casestudy.comment_management.business.abstracts.TaskService;
import com.casestudy.comment_management.core.utilities.exceptions.types.BusinessException;
import com.casestudy.comment_management.dataAccess.TaskRepository;
import com.casestudy.comment_management.entities.concretes.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TaskBusinessRules {

    private TaskService taskService;

    public void checkIfTaskExist(int id){
        Task task = taskService.getTaskById(id);

        if(task == null){
            throw new BusinessException("Task is not exist!");
        }
    }
}
