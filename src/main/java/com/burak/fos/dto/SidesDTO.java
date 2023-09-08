package com.burak.fos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SidesDTO {

    private Long id;
    private String name;
    private String size;
    private double kcal;
    private double carbonhydrate;
    private double fat;
    private double protein;
    private double price;
}
