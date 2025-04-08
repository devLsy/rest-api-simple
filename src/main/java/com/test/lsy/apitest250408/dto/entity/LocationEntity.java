package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "loc_info")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private int streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private int postcode;
    private String latitude;
    private String longitude;

    @Builder
    public LocationEntity(int streetNumber, String streetName, String city, String state, String country, int postcode, String latitude, String longitude) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
