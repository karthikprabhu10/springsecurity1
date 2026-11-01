package com.jsp.securityexample.service;

import com.jsp.securityexample.entity.User;

public interface UserService {
    public String greeting();
    public User signup(User user);

    String signin(String username, String password);
}
