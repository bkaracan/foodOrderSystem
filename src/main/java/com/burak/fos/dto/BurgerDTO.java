package com.burak.fos.dto;

import java.util.List;
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
public class BurgerDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private double carbonhydrate;
    private double fat;
    private double protein;
    private List<ToppingDTO> toppings;

}
