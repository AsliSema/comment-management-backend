package com.casestudy.comment_management.entities.concretes;

import com.casestudy.comment_management.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tasks")
public class Task extends BaseEntity {

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "task")
    @ToString.Exclude
    private List<Comment> comments;


}
