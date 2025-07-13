package com.example.TechitEasy.models;

import jakarta.persistence.*;

@Entity
@Table(name="cimodules")
public class CIModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private double price;

    @ManyToOne
    @JoinColumn(name = "television_id", referencedColumnName = "id")
    private Television television;
}
