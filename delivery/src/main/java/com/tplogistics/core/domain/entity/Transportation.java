package com.tplogistics.core.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "transportation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Transportation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID transportationId;

    /*
     * Current garage
     * */
    //TODO: Update relation between Transportation - Garage
//    @ManyToOne()
//    @JoinColumn(name = "from_location_id")
//    Location fromLocation;

    String licensePlate;
    Double load;
    Integer deliveryStatus;

    /*
    * Reference
    * */
    @OneToMany(mappedBy = "transportation", cascade = CascadeType.ALL)
    List<Job> jobs;
}
