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

    String name;
    String address;
    Double latitude;
    Double longitude;
}
