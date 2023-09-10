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
public class ToppingDTO {

    private Long id;
    private String name;
    private double price;
    private BurgerDTO burgerDTO;

}
