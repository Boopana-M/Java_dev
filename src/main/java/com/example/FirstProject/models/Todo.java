package com.example.FirstProject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    Long id;
    String title;
    String description;
    Boolean isCompleted;
}


