package com.casestudy.comment_management.controllers;


import com.casestudy.comment_management.business.abstracts.AuthService;
import com.casestudy.comment_management.business.dtos.request.user.LoginRequest;
import com.casestudy.comment_management.business.dtos.request.user.RegisterRequest;
import com.casestudy.comment_management.business.dtos.response.user.GetUserResponse;
import com.casestudy.comment_management.business.dtos.response.user.LoginResponse;
import com.casestudy.comment_management.business.dtos.response.user.RegisterResponse;
import com.casestudy.comment_management.entities.concretes.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }


    @PostMapping("/getUserByEmail")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse findByEmail(@RequestBody String email){
        return authService.getUserByEmail(email);
    }

}
