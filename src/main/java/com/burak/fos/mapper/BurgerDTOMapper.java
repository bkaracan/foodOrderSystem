package com.burak.fos.mapper;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.entity.Burger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BurgerDTOMapper {

    public Burger convertToEntity(BurgerDTO burgerDTO) {

        Burger burger = new Burger();
        burger.setId(burgerDTO.getId());
        burger.setName(burgerDTO.getName());
        burger.setDescription(burgerDTO.getDescription());
        burger.setPrice(burgerDTO.getPrice());
        burger.setCarbonhydrate(burgerDTO.getCarbonhydrate());
        burger.setFat(burgerDTO.getFat());
        burger.setProtein(burgerDTO.getProtein());
        return burger;
    }

    public BurgerDTO convertToDto(Burger burger) {

        return BurgerDTO.builder()
                .id(burger.getId())
                .name(burger.getName())
                .description(burger.getDescription())
                .price(burger.getPrice())
                .carbonhydrate(burger.getCarbonhydrate())
                .fat(burger.getFat())
                .protein(burger.getProtein())
                .build();
    }

    public List<Burger> convertToEntityList(List<BurgerDTO> burgerDTOs) {

        return burgerDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public List<BurgerDTO> convertToDtoList(List<Burger> burgerList) {

        return burgerList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
