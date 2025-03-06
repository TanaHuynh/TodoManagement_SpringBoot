package com.example.todo_springboot.controller;

import com.example.todo_springboot.dto.JwtAuthenResponse;
import com.example.todo_springboot.dto.LoginDto;
import com.example.todo_springboot.dto.RegisterDto;
import com.example.todo_springboot.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    // Build Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        JwtAuthenResponse jwtAuthenResponse = new JwtAuthenResponse();
        jwtAuthenResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthenResponse, HttpStatus.OK);
    }
}
