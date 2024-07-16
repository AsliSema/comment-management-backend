package com.casestudy.comment_management.dataAccess;

import com.casestudy.comment_management.business.dtos.response.user.GetUserResponse;
import com.casestudy.comment_management.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
 User findById(int id);

 Optional<User> findByEmail(String email);


}
