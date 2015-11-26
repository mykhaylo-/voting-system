package com.michael.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;

    private final String name;

    private final double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }
}
