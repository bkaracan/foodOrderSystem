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
@Table(name = "beverage")
public class Beverage {

    @Id
    @SequenceGenerator(name = "BEVERAGE_ID_GENERATOR", sequenceName = "BEVERAGE_ID_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BEVERAGE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private double price;




}
