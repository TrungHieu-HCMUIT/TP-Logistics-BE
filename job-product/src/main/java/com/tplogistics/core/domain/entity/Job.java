package com.tplogistics.core.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "job")
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID jobId;

    // Job's information
    UUID driverId;
    UUID transportationId;
    UUID routeId;
    UUID fromGarage;
    UUID toGarage;
    Double total;
    String pickupContactName;
    String pickupContactNo;
    String unloadContactName;
    String unloadContactNo;
    String noteToDriver;

    // Job's progress
    Integer jobStatus;
    // Time statistics
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date assignedAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date acceptedAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date pickupArriveAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date pickupDoneAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date unloadArriveAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date unloadDoneAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date completedAt;

    /*
     * Reference
     * */
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    List<JobProduct> jobProducts;
}
