package com.casestudy.comment_management.business.rules;

import com.casestudy.comment_management.business.abstracts.TaskService;
import com.casestudy.comment_management.business.abstracts.AuthService;
import com.casestudy.comment_management.core.utilities.exceptions.types.BusinessException;
import com.casestudy.comment_management.dataAccess.CommentRepository;
import com.casestudy.comment_management.entities.concretes.Comment;
import com.casestudy.comment_management.entities.concretes.Task;
import com.casestudy.comment_management.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentBusinessRules {

    private CommentRepository commentRepository;
    private TaskService taskService;
    private AuthService authService;

    public void checkIfCommentExist(int commentId){
        Comment comment = commentRepository.findById(commentId);

        if(comment == null){
            throw new BusinessException("Comment is not exist!");
        }
    }

    public void checkIfTaskExist(int id){
        Task task = taskService.getTaskById(id);

        if(task == null){
            throw new BusinessException("Task is not exist!");
        }
    }

    public void checkIfUserExist(int id){
        User user = authService.getUserById(id);

        if(user == null){
            throw new BusinessException("User is not exist!");
        }
    }

    public void checkIfPermittedUser(int commentId, int reqUserId){
        Comment comment = commentRepository.findById(commentId);

        if(comment.getUser().getId() != reqUserId){
            throw new BusinessException("You are not allowed to do that!");
        }
    }

}
