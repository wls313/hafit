package com.habit.hafit.auth;

import com.habit.hafit.auth.dto.UserJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    @Override
    public User save(UserJoinDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .gender(dto.getGender())
                .exerciseGoal(dto.getExerciseGoal())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .targetWeight(dto.getTargetWeight())
                .weeklyGoal(dto.getWeeklyGoal())
                .targetMuscleGroup(dto.getTargetMuscleGroup())
                .build();
        return authRepository.save(user);
    }
}