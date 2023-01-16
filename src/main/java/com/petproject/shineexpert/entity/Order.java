package com.petproject.shineexpert.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wash_order")
public class Order extends BaseEntity {

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "comment")
    private String comment;

    @Column(name = "price")
    private String price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_services", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Services> services = new ArrayList<>();
}
