package com.jsp.securityexample.service.impl;

import com.jsp.securityexample.entity.User;
import com.jsp.securityexample.repository.UserRepository;
import com.jsp.securityexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String greeting() {
        return "hello";
    }

    @Override
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String signin(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword()))
         {
            return "user logged in";

        }else {
            return "user login error";
        }


    }


}
