package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
}
