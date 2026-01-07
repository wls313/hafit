package com.habit.hafit.auth.dto;

import com.habit.hafit.auth.userAuth.ExerciseGoal;
import com.habit.hafit.auth.userAuth.Gender;
import com.habit.hafit.auth.userAuth.TargetMuscleGroup;
import lombok.Data;

import java.util.List;

@Data
public class UserJoinDto {
    private String email;
    private String nickname;
    private Gender gender;
    private ExerciseGoal exerciseGoal;
    private Double height;
    private Double weight;
    private Double targetWeight;
    private Integer weeklyGoal;
    private List<TargetMuscleGroup> targetMuscleGroup;
}