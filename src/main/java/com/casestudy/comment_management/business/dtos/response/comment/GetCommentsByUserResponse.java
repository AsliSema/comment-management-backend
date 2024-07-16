package com.casestudy.comment_management.business.dtos.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentsByUserResponse {
    private int id;
    private String content;
    private int userId;
    private int taskId;
    private String title;
    private String description;
    private String userName;
    private LocalDateTime createdDate;
}
