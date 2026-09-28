package com.example.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.FirstProject.models.Todo;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    public ToDoService ts;
    @GetMapping("/get")
    String getTodo() {
        return "Todo";
    }

    @GetMapping("/{id}")// {id} is a empty box and /1 /2 /3 anything can suit with that
    String getToDoByID(@PathVariable long id) {
        return "Id" + id+ " Ipo neraya page iruku nu vei.. unaku entha page venumnnu nee adicha inga {id} nu oru placeholder irukum and atha extract panni output la add pandrathu tha @PathVariable oda velai ";
    }

    @GetMapping
    String getTodo(
            @RequestParam long id,
            @RequestParam String name) {

        return id + " " + name;
    }
    @GetMapping
    String getToDoIdByParamAndWithName(@RequestParam("todoId") long id)
    {
        return "Todo with ID :"+id+ "ithula nee ? ku aprom oru peru kuduthu value kudukalam and ithu String getToDoIdByParamAndWithName(@RequestParam(\"todoId\") long id) ipdi kudutha work aagum";
    }

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(ts.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    String updateToDoList()
    {
        return "Todo with id : ***";
    }

    @DeleteMapping("/{id}")
    String deleteToDoList(@PathVariable long id)
    {
        return "Deleted Todo with id : "+id;
    }
}
