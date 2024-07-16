package com.casestudy.comment_management.dataAccess;

import com.casestudy.comment_management.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findById(int id);

    List<Comment> getCommentsByUserId(int userId);
}
