package com.example.FirstProject.service;
import java.util.*;

import com.example.FirstProject.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.FirstProject.models.Todo;

@Service
public class UserService {
    @Autowired
    private UserRepository u;

    public Todo createTodo(User user {
        return u.save(todo);
    }

    public Todo getToDoByID(Long id)
    {
        return u.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }


}
