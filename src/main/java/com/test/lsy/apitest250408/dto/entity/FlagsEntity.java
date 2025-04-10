package com.test.lsy.apitest250408.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "flag_tb")
public class FlagsEntity {

    @Id
    private String id;

    @Schema(description = "png")
    private String png;

    @Schema(description = "svg")
    private String svg;

    @Column(length = 1000)
    @Schema(description = "alt")
    private String alt;

    @Builder
    public FlagsEntity(String png, String svg, String alt) {
        this.png = png;
        this.svg = svg;
        this.alt = alt;
    }
}
