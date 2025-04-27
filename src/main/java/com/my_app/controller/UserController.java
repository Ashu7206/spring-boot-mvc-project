package com.my_app.controller;

import com.my_app.entity.User;
import com.my_app.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/msg")
    public String msg(){
        return "Hello Message";
    }

    @GetMapping("/get-all/{pageNo}/{pageSize}")
    public ResponseEntity<?> getAllUsers(@PathVariable int pageNo,@PathVariable int pageSize){
        Page<User> users = userService.getUsers(pageNo, pageSize);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
