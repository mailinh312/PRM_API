package com.app.api.api.controller.auth;

import com.app.api.model.User;
import com.app.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/uid")
    public Optional<User> getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
