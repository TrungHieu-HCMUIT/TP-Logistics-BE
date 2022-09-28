package com.tplogistics.core.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    UUID productId;

    String name;
    String unit;
    Integer type;
}
