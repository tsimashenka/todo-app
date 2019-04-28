package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Todo;
import com.example.service.TodoService;

@Component
public class initData {

    @Autowired
    private TodoService todoService;

    public void Init() {

        List<Todo> todos = new ArrayList<Todo>();

        todos.add(
            new Todo(
                "Create todo app",
                "Let's just copy existing one and adopt for our needs.")
            );

        todos.add(
            new Todo(
                "Deploy app on Heroku",
                "Login to heroku and do the job done."
            )
        );

        for(Todo t : todos) {
            todoService.add(t);
        }
    }
}