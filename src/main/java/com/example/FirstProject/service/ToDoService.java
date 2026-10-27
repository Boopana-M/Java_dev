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
public class ToDoService {
    @Autowired
    private ToDoRepository t;

    public Todo createTodo(Todo todo){
       return t.save(todo);
    }

    public Todo getToDoByID(Long id)
    {
        return t.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }
    public Page<Todo> getTodoByPage(int pageno, int size)
    {
        Pageable pageable = PageRequest.of(pageno,size);
        return t.findAll(pageable);
    }
    public List<Todo> getTodoos(){
        return t.findAll();
    }

    public Todo updateTodo(Long id,Todo todo)
    {
        Todo prev = t.findById(id).orElseThrow();
        prev.setTitle(todo.getTitle());
        prev.setIsCompleted(todo.getIsCompleted());
        return t.save(prev);
    }

    public void deleteTodo(Todo todo)
    {
        t.delete(todo);
    }

    public void deleteTodoByID(Long id)
    {
        t.delete(getToDoByID(id));
    }
}
