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

    private String seed;
    private int results;
    private int page;
    private String version;

    @Builder
    public PictureEntity(String seed, int results, int page, String version) {
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }
}
