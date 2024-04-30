package com.example.basedDemoApp.service;

import com.example.basedDemoApp.entity.UserEntity;
import com.example.basedDemoApp.exception.UserAlreadyExistException;
import com.example.basedDemoApp.exception.UserNotFoundException;
import com.example.basedDemoApp.model.User;
import com.example.basedDemoApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");

        };
        return userRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Пользователь с таким ID не был найден");
        }
        return User.toModel(optionalUser.get());
    }

    public Long deleteUserById(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
