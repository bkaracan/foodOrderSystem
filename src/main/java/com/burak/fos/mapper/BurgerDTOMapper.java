package com.burak.fos.mapper;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Burger;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BurgerDTOMapper {

    private final ToppingDTOMapper toppingDTOMapper;

    @Autowired
    public BurgerDTOMapper(ToppingDTOMapper toppingDTOMapper) {
        this.toppingDTOMapper = toppingDTOMapper;
    }

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

       BurgerDTO burgerDTO = new BurgerDTO();

        burgerDTO.setId(burger.getId());
        burgerDTO.setName(burger.getName());
        burgerDTO.setDescription(burger.getDescription());
        burgerDTO.setPrice(burger.getPrice());
        burgerDTO.setCarbonhydrate(burger.getCarbonhydrate());
        burgerDTO.setFat(burger.getFat());
        burgerDTO.setProtein(burger.getProtein());

        List<ToppingDTO> toppings = burger.getToppings().stream()
                .map(toppingDTOMapper::convertToDto)
                .collect(Collectors.toList());

        burgerDTO.setToppings(toppings);

        return burgerDTO;
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
