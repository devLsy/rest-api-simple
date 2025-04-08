package com.test.lsy.apitest250408.dto.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "emp_info")
public class EmpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String gender;
    private String titleName;
    private String firstName;
    private String lastName;

    @Builder
    public EmpEntity(String gender, String titleName, String firstName, String lastName) {
        this.gender = gender;
        this.titleName = titleName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
