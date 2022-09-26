package com.tplogistics.core.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "job_tracking")
public class JobTracking {
    @Id
    UUID id;

    UUID jobId;
    Double latitude;
    Double longitude;

    @Temporal(TemporalType.DATE)
    Date createdAt;
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer order;
}
