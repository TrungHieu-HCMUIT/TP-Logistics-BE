package com.tplogistics.core.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "job_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JobProduct {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(updatable = false, nullable = false)
    UUID id;

    /*
     * From location
     * */
    @ManyToOne()
    @JoinColumn(name = "job_id")
    Job job;
    /*
     * To location
     * */
    @ManyToOne()
    @JoinColumn(name = "product_id")
    Product product;

    Integer quantity;
    Double grandTotal;

}
