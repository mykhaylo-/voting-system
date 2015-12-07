package com.michael.votingsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Menu lunchMenu;

    public void setLunchMenu(Menu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public void setName(String name) {

        this.name = name;
    }

    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(lunchMenu, that.lunchMenu) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lunchMenu, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", lunchMenu=" + lunchMenu +
                ", name='" + name + '\'' +
                '}';
    }
}