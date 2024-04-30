package com.example.basedDemoApp.service;

import com.example.basedDemoApp.entity.ToDoEntity;
import com.example.basedDemoApp.entity.UserEntity;
import com.example.basedDemoApp.model.ToDo;
import com.example.basedDemoApp.repository.ToDoRepo;
import com.example.basedDemoApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServive {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo(ToDoEntity toDo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        toDo.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDo));
    }

    public ToDo completeToDo(Long id){
        ToDoEntity toDo = toDoRepo.findById(id).get();
        toDo.setCompleted(!toDo.getCompleted());
        return ToDo.toModel(toDoRepo.save(toDo));
    }
}
