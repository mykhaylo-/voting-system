package com.michael.votingsystem.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.stream.Stream;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne
    private Menu lunchMenu;

    public void setLunchMenu(Menu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public void setName(String name) {

        this.name = name;
    }

    private String name;

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Menu getLunchMenu() {
        return lunchMenu;
    }
}