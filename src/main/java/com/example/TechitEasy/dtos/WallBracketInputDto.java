package com.example.TechitEasy.dtos;

import jakarta.validation.constraints.NotBlank;

public class WallBracketInputDto {
    @NotBlank
    private Long id;
    private String size;
    private boolean adjustable;
    private String name;
    private double price;
}
