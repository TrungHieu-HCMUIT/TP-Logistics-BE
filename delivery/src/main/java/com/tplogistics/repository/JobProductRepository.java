package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.JobProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobProductRepository extends JpaRepository<JobProduct, UUID> {

}
