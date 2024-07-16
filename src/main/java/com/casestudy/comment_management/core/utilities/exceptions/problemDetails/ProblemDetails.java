package com.casestudy.comment_management.core.utilities.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String Status;
    private String Type;
}
