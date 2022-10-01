package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {
    List<Route> findByIgnoreCaseFromLocation_NameContainingAndIgnoreCaseToLocation_NameContaining(String fromLocationKeyword, String toLocationKeyword);
    List<Route> findByIgnoreCaseFromLocation_NameContaining(String fromLocationKeyword);
    List<Route> findByIgnoreCaseToLocation_NameContaining(String toLocationKeyword);
}
