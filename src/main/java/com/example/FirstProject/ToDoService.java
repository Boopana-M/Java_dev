package com.example.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository t;

    public String printToDos()
    {
        return t.getAllToDos();
    }
}
