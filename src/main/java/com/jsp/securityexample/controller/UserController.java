package com.jsp.securityexample.controller;

import com.jsp.securityexample.entity.User;
import com.jsp.securityexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public String greeting(){
    return  userService.greeting();
}

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public  String signin(@RequestHeader String username, @RequestHeader String password){
        return userService.signin(username,password);
    }
}
