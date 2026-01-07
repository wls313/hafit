package com.habit.hafit.auth;

import com.habit.hafit.auth.userAuth.ExerciseGoal;
import com.habit.hafit.auth.userAuth.ExerciseLevel;
import com.habit.hafit.auth.userAuth.Gender;
import com.habit.hafit.auth.userAuth.TargetMuscleGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ExerciseGoal exerciseGoal;

    @Enumerated(EnumType.STRING)
    private ExerciseLevel level;

    @ElementCollection(targetClass = TargetMuscleGroup.class)
    @CollectionTable(name = "user_target_parts", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<TargetMuscleGroup> targetMuscleGroup = new ArrayList<>();

    private Double height;

    private Double weight;

    private Double targetWeight;

    private Integer weeklyGoal;

    @Builder
    public User(String email, String nickname, Gender gender, ExerciseGoal exerciseGoal,
                Double height, Double weight,
                Double targetWeight, List<TargetMuscleGroup> targetMuscleGroup, Integer weeklyGoal) {
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.exerciseGoal = exerciseGoal;
        this.height = height;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.targetMuscleGroup = (targetMuscleGroup != null) ? targetMuscleGroup : new ArrayList<>();
        this.level = null; //초기값은 미정 이후 운동량으로 측정
        this.weeklyGoal = weeklyGoal;
    }

    public void updateLevel(ExerciseLevel newLevel) {
        this.level = newLevel;
    }
}