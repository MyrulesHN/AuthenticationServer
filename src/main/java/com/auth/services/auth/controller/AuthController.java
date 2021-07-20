package com.auth.services.auth.controller;


import com.auth.services.auth.UserNotFoundException;
import com.auth.services.auth.entity.AuthRequest;
import com.auth.services.auth.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtToken jwtToken;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateTokenForUser(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jwtToken.generateToken("Bearer "+authRequest.getUsername());
    }

    @GetMapping
    public String getMessage() {
        return "Welcome you have login, tie to generate the bearer token";
    }
}
