package com.tplogistics.core.domain.entity;

import com.tplogistics.core.domain.enums.JobStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;

    Integer driverId;
    Integer transportationId;
    Integer pickUpLocationId;
    Integer deliveryLocationId;

    @Temporal(TemporalType.DATE)
    Date createdAt;

    @Temporal(TemporalType.DATE)
    Date completedAt;

    @Enumerated(value = EnumType.ORDINAL)
    JobStatus status;

    Double distance;
    Double total;
}
