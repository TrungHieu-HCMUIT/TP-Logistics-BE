package com.tplogistics.core.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "driver_job")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverJob {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID driverJobId;

    /*
    * Reference
    * */
    @ManyToOne()
    @JoinColumn(name = "job_id")
    Job job;

    UUID driverId;

    Double labourCost;
    Double additionalCost;

    Integer type;
    Double distance;
    String comment;
}
