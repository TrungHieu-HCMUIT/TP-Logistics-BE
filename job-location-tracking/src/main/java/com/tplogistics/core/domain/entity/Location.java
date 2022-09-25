package com.tplogistics.core.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "location")
public class Location {
    @Id
    UUID id;

    @Column(name = "type")
    Integer locationType;
    String address;
    Double latitude;
    Double longitude;
}
