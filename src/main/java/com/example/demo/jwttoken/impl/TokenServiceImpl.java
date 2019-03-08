package com.example.demo.jwttoken.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.domain.User;
import com.example.demo.jwttoken.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        String token="";
        token = JWT.create()
                .withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassWord()));
        return token;
    }
}
