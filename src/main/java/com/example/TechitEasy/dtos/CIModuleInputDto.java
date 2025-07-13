package com.example.TechitEasy.dtos;

import jakarta.validation.constraints.NotBlank;

public class CIModuleInputDto {
    @NotBlank
    private String name;
    private String type;
    private double price;
}
