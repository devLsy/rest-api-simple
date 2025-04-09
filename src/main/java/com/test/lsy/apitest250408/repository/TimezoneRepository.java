package com.test.lsy.apitest250408.repository;

import com.test.lsy.apitest250408.dto.entity.TimezoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimezoneRepository extends JpaRepository<TimezoneEntity, Long> {
}
