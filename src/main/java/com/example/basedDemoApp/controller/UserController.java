package com.example.basedDemoApp.controller;

import com.example.basedDemoApp.entity.UserEntity;
import com.example.basedDemoApp.exception.UserAlreadyExistException;
import com.example.basedDemoApp.exception.UserNotFoundException;
import com.example.basedDemoApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранён");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body (e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body ("Ошибка сервера");
        }
    }

    @GetMapping("")
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка сервера");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUserById(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка сервера");
        }
    }
}
