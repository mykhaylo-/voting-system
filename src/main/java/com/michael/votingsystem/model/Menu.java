package com.michael.votingsystem.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Dish> dishes;

    public Menu(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }
}
