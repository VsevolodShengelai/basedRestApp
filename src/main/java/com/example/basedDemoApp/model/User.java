package com.example.basedDemoApp.model;

import com.example.basedDemoApp.entity.ToDoEntity;
import com.example.basedDemoApp.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<ToDo> todos;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        //Преобразование "массива" entity's к массиву model's
        model.setTodos(entity.getTodos().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return model;
    };

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
