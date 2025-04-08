package com.test.lsy.apitest250408.repository;

import com.test.lsy.apitest250408.dto.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoEntity, Long> {
}
