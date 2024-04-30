package com.example.basedDemoApp.repository;

import com.example.basedDemoApp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
