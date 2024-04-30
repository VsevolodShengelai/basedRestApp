package com.example.basedDemoApp.controller;

import com.example.basedDemoApp.entity.ToDoEntity;
import com.example.basedDemoApp.service.ToDoServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoServive toDoServive;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(toDoServive.createToDo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(toDoServive.completeToDo(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
