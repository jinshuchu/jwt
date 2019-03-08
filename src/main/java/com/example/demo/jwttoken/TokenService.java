package com.example.demo.jwttoken;

import com.example.demo.domain.User;

public interface TokenService {
    String getToken(User user);
}
