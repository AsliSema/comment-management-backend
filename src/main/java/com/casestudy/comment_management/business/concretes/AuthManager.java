package com.casestudy.comment_management.business.concretes;

import com.casestudy.comment_management.business.abstracts.AuthService;
import com.casestudy.comment_management.business.dtos.request.user.LoginRequest;
import com.casestudy.comment_management.business.dtos.request.user.RegisterRequest;
import com.casestudy.comment_management.business.dtos.response.user.GetUserResponse;
import com.casestudy.comment_management.business.dtos.response.user.LoginResponse;
import com.casestudy.comment_management.business.dtos.response.user.RegisterResponse;
import com.casestudy.comment_management.core.enums.Role;
import com.casestudy.comment_management.core.security.JwtService;
import com.casestudy.comment_management.core.utilities.exceptions.types.BusinessException;
import com.casestudy.comment_management.core.utilities.mapping.ModelMapperService;
import com.casestudy.comment_management.dataAccess.UserRepository;
import com.casestudy.comment_management.entities.concretes.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthManager implements AuthService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private BCryptPasswordEncoder passwordEncoder;

    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthManager(UserRepository userRepository, ModelMapperService modelMapperService, BCryptPasswordEncoder passwordEncoder, JwtService jwtService, @Lazy AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public RegisterResponse register(RegisterRequest request) {

//        userBusinessRules.checkIfUserExist(request.getEmail());
//        userBusinessRules.checkIfPasswordWrittenCorrectly(request.getPassword(), request.getConfirmPassword());

        User newUser = User
                .builder()
                .profileName(request.getProfileName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        newUser.setCreatedDate(LocalDateTime.now());
        userRepository.save(newUser);

        RegisterResponse response = this.modelMapperService.forResponse().map(newUser, RegisterResponse.class);
        return response;

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        //sonradan ekle kontrol et!
//        userBusinessRules.checkUserPresence(request.getEmail());
        Optional<User> user = userRepository.findByEmail(request.getEmail());


        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            throw new IllegalStateException("Wrong email or password!");
        }

        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            String token = null;

            if (authentication.isAuthenticated()) {
                token = jwtService.generateToken(request.getEmail());
            } else {
                new BusinessException("Invalid email!");
            }

            LoginResponse response = LoginResponse
                    .builder()
                    .id(user.get().getId())
                    .profileName(user.get().getProfileName())
                    .email(user.get().getEmail())
                    .role(user.get().getRole().name())
                    .bareerToken(token)
                    .build();

            return response;
        } catch (Exception e) {
            throw new BusinessException("Authentication failed: " + e.getMessage());
        }


    }

    @Override
    public GetUserResponse getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        GetUserResponse response = modelMapperService.forResponse().map(user.get(), GetUserResponse.class);
        return response;

    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not exists!"));
    }
}
