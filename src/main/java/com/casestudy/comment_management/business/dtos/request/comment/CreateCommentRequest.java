package com.casestudy.comment_management.business.dtos.request.comment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequest {

    @NotNull(message = "Content cannot be null!")
    @Size(min=5, message = "Content must be at least 5 characters!")
    private String content;

    @NotNull(message = "taskId cannot be null!")
    private int taskId;

    @NotNull(message = "userId cannot be null!")
    private int userId;
}
