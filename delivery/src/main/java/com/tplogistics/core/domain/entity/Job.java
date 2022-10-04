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

    @ManyToOne
    @JoinColumn(name = "transportation_id")
    Transportation transportation;

    @ManyToOne()
    @JoinColumn(name = "route_id")
    Route route;

    UUID fromGarage;
    UUID toGarage;
    Double distance;
    Double total;
    String pickupContactName;
    String pickupContactNo;
    String unloadContactName;
    String unloadContactNo;
    String noteToDriver;

    // Job's progress
    Integer jobStatus;
    // Time statistics
    @Temporal(TemporalType.DATE)
    Date createdAt;
    @Temporal(TemporalType.DATE)
    Date assignedAt;
    @Temporal(TemporalType.DATE)
    Date acceptedAt;
    @Temporal(TemporalType.DATE)
    Date pickupArriveAt;
    @Temporal(TemporalType.DATE)
    Date pickupDoneAt;
    @Temporal(TemporalType.DATE)
    Date unloadArriveAt;
    @Temporal(TemporalType.DATE)
    Date unloadDoneAt;
    @Temporal(TemporalType.DATE)
    Date completedAt;

    /*
     * Reference
     * */
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    List<DriverJob> driverJobs;
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    List<JobProduct> jobProducts;

}
