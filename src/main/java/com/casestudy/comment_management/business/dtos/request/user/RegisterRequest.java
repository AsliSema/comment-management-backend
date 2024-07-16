package com.casestudy.comment_management.business.dtos.request.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotNull(message = "Username cannot be null!")
    @Size(min = 5, max= 15, message = "Username must be between 5 to 15 characters!")
    private String profileName;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid email address!")
    private String email;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "Password must contain at least one lowercase letter, one uppercase letter and one digit character.")
    private String password;


}
