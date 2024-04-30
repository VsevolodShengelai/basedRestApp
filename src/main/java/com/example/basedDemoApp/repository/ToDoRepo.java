package com.example.basedDemoApp.repository;

import com.example.basedDemoApp.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
