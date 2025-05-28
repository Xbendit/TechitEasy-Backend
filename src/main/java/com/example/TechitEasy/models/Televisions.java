package com.example.TechitEasy.models;

public class Televisions {

    private static int counter = 1;

    private int id;
    private String name;

    public Televisions(String name) {
        this.id = counter ++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Televisions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
