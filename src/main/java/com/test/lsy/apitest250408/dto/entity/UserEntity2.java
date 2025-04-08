package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_info3")
public class UserEntity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String gender;
    private String name;
    private int id;
    private String email;
    private String status;

    @Builder
    public UserEntity2(String gender, String name, int id, String email, String status) {
        this.gender = gender;
        this.name = name;
        this.id = id;
        this.email = email;
        this.status = status;
    }
}

