package com.casestudy.comment_management.business.concretes;

import com.casestudy.comment_management.business.abstracts.CommentService;
import com.casestudy.comment_management.business.dtos.request.comment.CreateCommentRequest;
import com.casestudy.comment_management.business.dtos.response.comment.CreatedCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetAllCommentsResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentsByUserResponse;
import com.casestudy.comment_management.business.rules.CommentBusinessRules;
import com.casestudy.comment_management.core.utilities.mapping.ModelMapperService;
import com.casestudy.comment_management.dataAccess.CommentRepository;
import com.casestudy.comment_management.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapperService modelMapperService;
    private CommentBusinessRules commentBusinessRules;

    @Override
    public CreatedCommentResponse add(CreateCommentRequest request) {

        commentBusinessRules.checkIfTaskExist(request.getTaskId());
        commentBusinessRules.checkIfUserExist(request.getUserId());

        Comment comment = this.modelMapperService.forRequest().map(request, Comment.class);
        comment.setCreatedDate(LocalDateTime.now());
        Comment createdComment = this.commentRepository.save(comment);


        CreatedCommentResponse createdCommentResponse = this.modelMapperService.forResponse().map(createdComment, CreatedCommentResponse.class);
        return createdCommentResponse;
    }

    @Override
    public GetCommentResponse getComment(int id) {

        commentBusinessRules.checkIfCommentExist(id);

        Comment comment = this.commentRepository.findById(id);
        GetCommentResponse commentResponse = this.modelMapperService.forResponse().map(comment, GetCommentResponse.class);

        return commentResponse;
    }

    @Override
    public List<GetAllCommentsResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<GetAllCommentsResponse>  response = comments.stream().map(comment -> modelMapperService.forResponse().map(comment, GetAllCommentsResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public String deleteComment(int commentId, int userId) {
        commentBusinessRules.checkIfCommentExist(commentId);
        commentBusinessRules.checkIfUserExist(userId);
        commentBusinessRules.checkIfPermittedUser(commentId, userId);

        commentRepository.deleteById(commentId);
        return "Comment deleted!";
    }

    @Override
    public List<GetCommentsByUserResponse> getCommentsBelongUser(int userId) {
        List<Comment> comments = commentRepository.getCommentsByUserId(userId);
        List<GetCommentsByUserResponse>  response = comments.stream().map(comment -> modelMapperService.forResponse().map(comment, GetCommentsByUserResponse.class)).collect(Collectors.toList());

        return response;
    }

}
