package com.petproject.shineexpert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner extends BaseEntity {

    @Column(name = "phone")
    private String phone;

    @Column(name = "first_number")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "visit_amount")
    private Integer visitCounter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars = new ArrayList<>();

    public void incrementVisitCounter() {
        visitCounter++;
    }
}
