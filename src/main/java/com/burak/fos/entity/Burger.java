package com.burak.fos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "burger")
public class Burger {

    @Id
    @SequenceGenerator(name = "BURGER_ID_GENERATOR", sequenceName = "BURGER_ID_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BURGER_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "carbonhydrate")
    private double carbonhydrate;

    @Column(name = "fat")
    private double fat;

    @Column(name = "protein")
    private double protein;
    
}
