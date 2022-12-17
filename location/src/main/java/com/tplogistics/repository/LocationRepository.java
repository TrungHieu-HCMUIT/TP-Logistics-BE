package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
    List<Location> findByNameIgnoreCaseContaining(String keyword);
}
