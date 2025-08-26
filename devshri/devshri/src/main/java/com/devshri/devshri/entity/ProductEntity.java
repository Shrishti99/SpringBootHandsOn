package com.devshri.devshri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String type;
}
