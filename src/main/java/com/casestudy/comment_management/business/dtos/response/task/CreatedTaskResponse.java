package com.casestudy.comment_management.business.dtos.response.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedTaskResponse {
    private int id;
    private String title;
    private String description;

}
