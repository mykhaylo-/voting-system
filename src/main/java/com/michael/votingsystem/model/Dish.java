package com.michael.votingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private double price;

    public void setId(Long id) {
        this.id = id;
    }

    public Dish() {
    }

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

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(price, dish.price) &&
                Objects.equals(id, dish.id) &&
                Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
