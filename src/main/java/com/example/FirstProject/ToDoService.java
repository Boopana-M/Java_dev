package com.example.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FirstProject.models.Todo;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository t;
    public Todo createTodo(Todo todo){
       return t.save(todo);
    }

}
