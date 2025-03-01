package com.emoli.galleryProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "saled_car", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"galleriest_id", "car_id", "customer_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "galleriest_id", nullable = false)
    private Galleriest galleriest;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
