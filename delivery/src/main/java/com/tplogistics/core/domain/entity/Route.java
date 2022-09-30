package com.tplogistics.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID routeId;

    /*
    * From location
    * */
    @ManyToOne()
    @JoinColumn(name = "from_location_id")
    Location fromLocation;
    /*
    * To location
    * */
    @ManyToOne()
    @JoinColumn(name = "to_location_id")
    Location toLocation;

    Double length;
    Double tripBasedCost;
    Double tonBasedCostPerKm;
    Double tonBasedLimit;
    Boolean isEnabled;

    /*
    * Reference
    * */
    @OneToMany(mappedBy = "fromLocation", cascade = CascadeType.ALL)
    List<Job> jobs;
}
