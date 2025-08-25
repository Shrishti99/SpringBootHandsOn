package com.devshri.devshri.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductEntity {

    private Long id;
    private String type;
    private String name;
    private Double price;
    private int quantity;
    private String description;

}
