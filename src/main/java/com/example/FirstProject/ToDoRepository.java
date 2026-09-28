package com.example.FirstProject;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FirstProject.models.Todo;
import org.springframework.stereotype.Component;


public interface ToDoRepository extends JpaRepository<Todo, Long> {

}
