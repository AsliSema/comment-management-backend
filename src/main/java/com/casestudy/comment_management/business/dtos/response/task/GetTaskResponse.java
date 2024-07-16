package com.casestudy.comment_management.business.dtos.response.task;

import com.casestudy.comment_management.business.dtos.response.comment.GetAllCommentsResponse;
import com.casestudy.comment_management.business.dtos.response.comment.GetCommentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskResponse {
    private int id;
    private String title;
    private String description;
    private List<GetAllCommentsResponse> comments;
}
