package com.example.teachertask.login;

import com.example.teachertask.allusers.User;
import com.example.teachertask.jwt.JwtUtil;
import com.example.teachertask.jwt.JwtValidator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

public class LoginController {
    private final LoginService loginService;
    private final JwtUtil jwtUtil;
    private final JwtValidator jwtValidator;
    @Autowired
    public LoginController(LoginService loginService, JwtUtil jwtUtil, JwtValidator jwtValidator) {
        this.loginService = loginService;
        this.jwtUtil = jwtUtil;
        this.jwtValidator = jwtValidator;
    }

    //    @Cacheable(value = "login", key = "id")
    @PostMapping("/login")
    public Map<String,Object> loginUser(@RequestBody LoginDTO loginDTO) {
        User user=loginService.loginUser(loginDTO);
        if(user!=null) {
            String token= jwtUtil.generateToken(user.getEmail(), user.getRole());
            Map<String,Object> response=new HashMap<>();
            response.put("user", user);
            response.put("token", token);
            return response;
        }else {
            throw new RuntimeException("Invalid email or password");
        }


    }
    @GetMapping("/validate-token")
    public Map<String, Object> validateToken(@RequestParam String token) {
        Claims claims = jwtValidator.validateToken(token);
        Map<String, Object> response = new HashMap<>();
        response.put("username", claims.getSubject());
        response.put("role", claims.get("role"));
        response.put("expiration", claims.getExpiration());
        return response;
    }
}
