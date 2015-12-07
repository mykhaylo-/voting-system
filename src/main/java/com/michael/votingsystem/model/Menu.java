package com.michael.votingsystem.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Collection<Dish> dishes;

    public Menu() {
    }

    public Menu(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDishes(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public Collection<Dish> getDishes() {
        return dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(dishes, menu.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishes);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishes=" + dishes +
                '}';
    }
}
