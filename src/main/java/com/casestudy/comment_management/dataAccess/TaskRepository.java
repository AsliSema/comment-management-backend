package com.casestudy.comment_management.dataAccess;

import com.casestudy.comment_management.entities.concretes.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findById(int id);
}
