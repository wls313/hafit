package com.habit.hafit.auth;

import com.habit.hafit.auth.dto.UserJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/process")
    public ResponseEntity<?> processAuth(@RequestBody UserJoinDto joinDto) {
        // 이메일로 기존 유저인지 먼저 확인
        return authService.findByEmail(joinDto.getEmail())
                .map(user -> {
                    // 1. 기존 유저라면 정보를 바로 반환 (로그인 처리)
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> {
                    // 2. 신규 유저라면 받은 데이터로 가입 진행
                    User newUser = authService.save(joinDto);
                    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
                });
    }
}