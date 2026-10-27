package com.example.FirstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FirstProject.models.Todo;


public interface ToDoRepository extends JpaRepository<Todo, Long> {

}
