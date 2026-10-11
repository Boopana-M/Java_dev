package com.example.FirstProject;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.FirstProject.models.Todo;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    public ToDoService ts;

    @GetMapping
    public List<Todo> getallTodos()
    {
        return ts.getTodoos();
    }
    @GetMapping("/{id}")
    ResponseEntity<Todo> getToDoByID(@PathVariable long id) {
        try {
            Todo created = ts.getToDoByID(id);
            return new ResponseEntity<>(created, HttpStatus.OK);
        }
        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    ResponseEntity<List<Todo>> getTodoos()
    {
       return new ResponseEntity<List<Todo>>(ts.getTodoos(),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo) {

            Todo created = ts.createTodo(todo);
            return new ResponseEntity<>(created, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodoById(@PathVariable Long id,@RequestBody Todo todo)
    {
       return new ResponseEntity<>(ts.updateTodo(id,todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteToDoList(@PathVariable long id)
    {
        ts.deleteTodoByID(id);
    }
}

