package com.test.lsy.apitest250408.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "flag_tb")
public class FlagsEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Schema(description = "png")
    private String png;

    @Schema(description = "svg")
    private String svg;

    @Column(length = 1000)
    @Schema(description = "alt")
    private String alt;

    @Builder

    public FlagsEntity(String id, String png, String svg, String alt) {
        this.id = UUID.randomUUID().toString();
        this.png = png;
        this.svg = svg;
        this.alt = alt;
    }
}
