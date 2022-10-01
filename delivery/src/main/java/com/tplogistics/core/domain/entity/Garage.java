package com.tplogistics.core.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "garage")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Garage {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID garageId;

    String name;
    String address;
    Double latitude;
    Double longitude;

    /*
     * Reference
     * */
//    @OneToMany(mappedBy = "fromLocation", cascade = CascadeType.ALL)
//    List<Route> fromLocation;
}
