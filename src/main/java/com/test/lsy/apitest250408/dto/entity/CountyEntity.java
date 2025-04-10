package com.test.lsy.apitest250408.dto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "country_tb")
public class CountyEntity {

    @Id
    private String id;

    @Schema(description = "국가명")
    private String countryName;

    @Schema(description = "정식 국가 영문명")
    private String officialEngName;

    @Schema(description = "대륙")
    private String region;

    @Builder
    public CountyEntity(String countryName, String officialEngName, String region) {
        this.countryName = countryName;
        this.officialEngName = officialEngName;
        this.region = region;
    }
}
