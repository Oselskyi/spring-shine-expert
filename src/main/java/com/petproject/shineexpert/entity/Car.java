package com.petproject.shineexpert.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car extends BaseEntity{

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "license_number", nullable = false)
    private String licenseNumber;

    @Column(name = "color")
    private String color;

    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
