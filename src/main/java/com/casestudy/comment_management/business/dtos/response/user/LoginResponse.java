package com.casestudy.comment_management.business.dtos.response.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private int id;
    private String profileName;
    private String email;
    private String role;
    private String bareerToken;
}
