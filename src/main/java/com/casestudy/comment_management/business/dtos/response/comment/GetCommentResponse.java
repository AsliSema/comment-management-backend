package com.casestudy.comment_management.business.dtos.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentResponse {
    private int id;
    private String content;
    private int userId;
    private String userName;
    private LocalDateTime createdDate;
}
