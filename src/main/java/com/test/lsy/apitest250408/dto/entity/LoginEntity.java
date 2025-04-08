package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "login_info")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    @Builder
    public LoginEntity(String uuid, String username, String password, String salt, String md5, String sha1, String sha256) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }
}
