package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_info4")
public class UserEntity4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private int id;
    private String website;
    private String zipcode;
    private String phone;
    private String name;
    private String username;
    private String city;
    private String street;
    private String suite;

    @Builder
    public UserEntity4(int id, String website, String zipcode, String phone, String name, String username, String city, String street, String suite) {
        this.id = id;
        this.website = website;
        this.zipcode = zipcode;
        this.phone = phone;
        this.name = name;
        this.username = username;
        this.city = city;
        this.street = street;
        this.suite = suite;
    }
}

