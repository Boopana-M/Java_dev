package com.example.FirstProject;

public class ToDoService {
    private ToDoRepository t;
    public ToDoService()
    {
        t = new ToDoRepository();
    }
    public void printToDos()
    {
        System.out.println(t.getAllToDos());
    }
}
