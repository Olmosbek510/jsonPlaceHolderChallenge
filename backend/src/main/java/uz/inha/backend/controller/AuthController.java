package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.inha.backend.dto.LoginDto;
import uz.inha.backend.dto.TokenEntity;
import uz.inha.backend.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<TokenEntity> login(@RequestBody LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        String token = "Bearer " + jwtUtil.generateToken(loginDto.getUsername());
        String refreshToken = "Bearer " + jwtUtil.generateRefreshToken(loginDto.getUsername());
        return ResponseEntity.ok(new TokenEntity(token, refreshToken));
    }
}
