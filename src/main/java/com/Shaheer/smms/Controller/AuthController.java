package com.Shaheer.smms.Controller;



import com.Shaheer.smms.Dto.AuthRequestDTO;
import com.Shaheer.smms.Dto.AuthResponseDTO;
import com.Shaheer.smms.Dto.RegisterRequestDTO;
import com.Shaheer.smms.Security.*;
import com.Shaheer.smms.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
