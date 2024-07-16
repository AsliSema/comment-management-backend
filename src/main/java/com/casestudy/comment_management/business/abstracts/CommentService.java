package com.casestudy.comment_management.business.abstracts;

import com.casestudy.comment_management.business.dtos.request.comment.CreateCommentRequest;
import com.casestudy.comment_management.business.dtos.response.comment.CreatedCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetAllCommentsResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentsByUserResponse;
import com.casestudy.comment_management.entities.concretes.Comment;

import java.util.List;

public interface CommentService {
    CreatedCommentResponse add(CreateCommentRequest request);

    GetCommentResponse getComment(int id);

    List<GetAllCommentsResponse> getAllComments();

    String deleteComment(int commentId, int userId);

    List<GetCommentsByUserResponse> getCommentsBelongUser(int userId);
}
