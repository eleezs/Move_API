package dev.elizs.movies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import dev.elizs.movies.service.AuthService;

@RestController
@RequestMapping("/api/v1/sign-up")

public class AuthController {
  
  @Autowired
  private class AuthService authService;
}
