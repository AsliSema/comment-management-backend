package com.casestudy.comment_management.business.abstracts;

import com.casestudy.comment_management.business.dtos.request.user.LoginRequest;
import com.casestudy.comment_management.business.dtos.request.user.RegisterRequest;
import com.casestudy.comment_management.business.dtos.response.user.GetUserResponse;
import com.casestudy.comment_management.business.dtos.response.user.LoginResponse;
import com.casestudy.comment_management.business.dtos.response.user.RegisterResponse;
import com.casestudy.comment_management.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    User getUserById(int id);

    GetUserResponse getUserByEmail(String email);

}
