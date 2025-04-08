package com.test.lsy.apitest250408.dto.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_info2")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;
    private String pictureUrl;

    @Builder
    public UserEntity(String gender, String firstName, String lastName, String email, String phone, String pictureUrl) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pictureUrl = pictureUrl;
    }
}
