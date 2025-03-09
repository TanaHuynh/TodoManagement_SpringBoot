package com.example.todo_springboot.service;

import com.example.todo_springboot.dto.JwtAuthenResponse;
import com.example.todo_springboot.dto.LoginDto;
import com.example.todo_springboot.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthenResponse login(LoginDto loginDto);
}
