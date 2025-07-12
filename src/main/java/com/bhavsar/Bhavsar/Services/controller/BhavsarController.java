package com.bhavsar.Bhavsar.Services.controller;

import com.bhavsar.Bhavsar.Services.model.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bhavsar")
public class BhavsarController {
      private List<UserDetails> userList = new ArrayList<>();
    @PostMapping("/create")
    public String createUser(@RequestBody UserDetails user) {
        userList.add(user);
        return "User created successfully";
    }
    @GetMapping("/getAll")
    public List<UserDetails> getAllUsers() {
        return userList;
    }
    @GetMapping("/get/{userId}")
    public UserDetails getUserById(@PathVariable int userId) {
        return userList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

}
