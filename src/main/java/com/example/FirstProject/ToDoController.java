package com.example.FirstProject;
import java.util.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.FirstProject.models.Todo;

@RestController
@RequestMapping("/todo")
@Slf4j
public class ToDoController {
    @Autowired
    public ToDoService ts;

    @GetMapping
    public List<Todo> getallTodos()
    {
        return ts.getTodoos();
    }

    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Todo Retrieved Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getToDoByID(@PathVariable long id) {
        try {
            Todo created = ts.getToDoByID(id);
            return new ResponseEntity<>(created, HttpStatus.OK);
        }
        catch(RuntimeException e){
            log.info("Error");
            log.warn("");
            log.error("",e);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    ResponseEntity<List<Todo>> getTodoos()
    {
       return new ResponseEntity<List<Todo>>(ts.getTodoos(),HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int pageno, @RequestParam int size)
    {
        return new ResponseEntity<>(ts.getTodoByPage(pageno,size),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@Valid @RequestBody Todo todo) {

            Todo created = ts.createTodo(todo);
            return new ResponseEntity<>(created, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodoById(@PathVariable Long id,@RequestBody Todo todo)
    {
       return new ResponseEntity<>(ts.updateTodo(id,todo),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteToDoList(@PathVariable long  id)
    {
        ts.deleteTodoByID(id);
    }
}

