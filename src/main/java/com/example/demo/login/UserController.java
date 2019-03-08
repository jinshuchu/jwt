package com.example.demo.login;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.jwtretention.UserLoginToken;
import com.example.demo.jwttoken.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private TokenService tokenService;
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject=new JSONObject();
        User user = new User();
        user.setUserName("你好");
        user.setPassWord("123456");
        user.setId("123");
        String token = tokenService.getToken(user);
        jsonObject.put("token", token);
        jsonObject.put("user", user);
        return jsonObject;
    }
    @UserLoginToken
    @RequestMapping(value="/messege",method = RequestMethod.GET)
    @ResponseBody
    public String getMessege(){
        return "通过验证";
    }
}
