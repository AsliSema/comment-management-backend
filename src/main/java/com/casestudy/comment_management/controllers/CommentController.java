package com.casestudy.comment_management.controllers;

import com.casestudy.comment_management.business.abstracts.CommentService;
import com.casestudy.comment_management.business.dtos.request.comment.CreateCommentRequest;
import com.casestudy.comment_management.business.dtos.request.task.CreateTaskRequest;
import com.casestudy.comment_management.business.dtos.response.comment.CreatedCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetAllCommentsResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentsByUserResponse;
import com.casestudy.comment_management.business.dtos.response.task.CreatedTaskResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private CommentService commentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCommentResponse add(@Valid  @RequestBody CreateCommentRequest request){
        return commentService.add(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCommentResponse getCommentById(@PathVariable int id){
        return commentService.getComment(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCommentsResponse> getComments(){
        return commentService.getAllComments();
    }


    @DeleteMapping("/{id}/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteComment(@PathVariable int id, @PathVariable int userId){
        return commentService.deleteComment(id, userId);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<GetCommentsByUserResponse> add(@Valid  @PathVariable int userId){
        return commentService.getCommentsBelongUser(userId);
    }

}
