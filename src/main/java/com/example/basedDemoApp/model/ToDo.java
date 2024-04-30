package com.example.basedDemoApp.model;

import com.example.basedDemoApp.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private boolean completed;

    public static ToDo toModel(ToDoEntity toDoEntity){
        ToDo model = new ToDo();
        model.setId(toDoEntity.getId());
        model.setTitle(toDoEntity.getTitle());
        model.setCompleted(toDoEntity.getCompleted());
        return model;
    }

    public ToDo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
