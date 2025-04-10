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
@Table(name = "country_tb")
public class CountyEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Schema(description = "국가명")
    private String countryName;

    @Schema(description = "정식 국가 영문명")
    private String officialEngName;

    @Schema(description = "대륙")
    private String region;

    @Builder

    public CountyEntity(Long id, String countryName, String officialEngName, String region) {
        this.id = UUID.randomUUID().toString();
        this.countryName = countryName;
        this.officialEngName = officialEngName;
        this.region = region;
    }
}
