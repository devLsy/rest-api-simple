package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "picture_info")
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String large;
    private String medium;
    private String thumbnail;

    @Builder

    public PictureEntity(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }
}
