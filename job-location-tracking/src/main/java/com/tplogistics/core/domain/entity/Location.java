package com.tplogistics.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;


}
