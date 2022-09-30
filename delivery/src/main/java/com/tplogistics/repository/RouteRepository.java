package com.tplogistics.repository;

import com.tplogistics.core.domain.entity.Location;
import com.tplogistics.core.domain.entity.Route;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RouteRepository {
    @Select("SELECT * FROM ROUTE r " +
            "JOIN LOCATION f ON f.id = r.from_location_id " +
            "JOIN LOCATION t ON t.id = r.to_location_id " +
            "WHERE UPPER(t.name) LIKE UPPER('%#{fromLocationKeyword}%')")
    @Results(value = {
            @Result(property = "id", column = "r.id"),
            @Result(property = "from", column = "from_location_id", one = @One(select = "findLocationByNameContaining")),
            @Result(property = "to", column = "to_location_id", one = @One(select = "findLocationByNameContaining"))
    })
    List<Route> findRouteByFromLocationNameAndToLocationName(String fromLocationKeyword, String toLocationKeyword);

    @Select("SELECT * FROM LOCATION WHERE UPPER(name) LIKE UPPER(#{keyword})")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "address", column = "address"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longitude", column = "longitude"),
    })
    Location findLocationByNameContaining(String keyword);
}
