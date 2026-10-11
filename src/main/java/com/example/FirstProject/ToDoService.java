package com.example.FirstProject;
import java.util.*;
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

    public Todo getToDoByID(Long id)
    {
        return t.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public List<Todo> getTodoos(){
        return t.findAll();
    }

    public Todo updateTodo(Long id,Todo todo)
    {
        Todo prev = t.findById(id).orElseThrow();
        prev.setTitle(todo.getTitle());
        prev.setDescription(todo.getDescription());
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
