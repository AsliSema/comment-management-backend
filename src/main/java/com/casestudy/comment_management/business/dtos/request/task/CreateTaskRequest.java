package com.casestudy.comment_management.business.dtos.request.task;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequest {

    @NotNull(message = "Title cannot be null!")
    @Size(min=3, max=50, message = "Title must be between 3 to 50 characters!")
    private String title;

    @NotNull(message = "Description cannot be null!")
    @Size(min=15, message = "Description must be at least 15 characters!")
    private String description;
}
