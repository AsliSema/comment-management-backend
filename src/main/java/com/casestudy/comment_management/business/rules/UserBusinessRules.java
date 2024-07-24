package com.casestudy.comment_management.business.rules;

import com.casestudy.comment_management.business.abstracts.AuthService;
import com.casestudy.comment_management.core.utilities.exceptions.types.BusinessException;
import com.casestudy.comment_management.dataAccess.UserRepository;
import com.casestudy.comment_management.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfUserExist(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            throw new BusinessException("User already exists!");
        }
    }

    public void checkUserPresence(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            throw new BusinessException("You Need to Register First!");
        }
    }


}
