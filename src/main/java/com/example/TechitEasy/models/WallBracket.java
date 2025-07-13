package com.example.TechitEasy.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="wallbrackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private boolean adjustable;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "wallBrackets", fetch = FetchType.EAGER)
    private Set<Television> televisions = new HashSet<>();

    public Long getId() {
        return id;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(Set<Television> televisions) {
        this.televisions = televisions;
    }
}
