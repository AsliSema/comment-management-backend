package com.casestudy.comment_management.business.dtos.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private int id;
    private String profileName;
    private String email;
}
