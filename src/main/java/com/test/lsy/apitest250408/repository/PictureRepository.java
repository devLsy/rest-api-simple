package com.test.lsy.apitest250408.repository;

import com.test.lsy.apitest250408.dto.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Long> {
}
