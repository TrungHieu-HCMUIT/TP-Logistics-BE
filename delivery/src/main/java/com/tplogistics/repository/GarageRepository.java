package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GarageRepository extends JpaRepository<Garage, UUID> {
    List<Garage> findByNameIgnoreCaseContaining(String keyword);
}
