package dev.abhiraz.grocery_backend.controller;

import dev.abhiraz.grocery_backend.auth.AuthenticationRequest;
import dev.abhiraz.grocery_backend.auth.AuthenticationResponse;
import dev.abhiraz.grocery_backend.auth.AuthenticationService;
import dev.abhiraz.grocery_backend.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
       // service.refreshToken(request, response);
    }

    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        return "Working....!!";
    }

}
