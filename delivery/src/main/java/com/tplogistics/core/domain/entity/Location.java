package com.tplogistics.core.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "location")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID locationId;

    String name;
    String address;
    Double latitude;
    Double longitude;

    /*
    * Reference
    * */
    @OneToMany(mappedBy = "fromLocation", cascade = CascadeType.ALL)
    List<Route> fromLocation;
    @OneToMany(mappedBy = "toLocation", cascade = CascadeType.ALL)
    List<Route> toLocation;
}
