package com.habit.hafit.auth;

import com.habit.hafit.auth.dto.UserJoinDto;

import java.util.Optional;

public interface AuthService {
    Optional<User> findByEmail(String email);
    User save(UserJoinDto dto);
}