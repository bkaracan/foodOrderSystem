package com.burak.fos.mapper;

import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Topping;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToppingDTOMapper {

    @Autowired
    private BurgerDTOMapper burgerDTOMapper;

    public Topping convertToEntity(ToppingDTO toppingDTO) {

        Topping topping = new Topping();
        topping.setId(toppingDTO.getId());
        topping.setName(toppingDTO.getName());
        topping.setPrice(toppingDTO.getPrice());

        return topping;
    }

    public ToppingDTO convertToDto(Topping topping) {

        ToppingDTO toppingDTO = new ToppingDTO();
        toppingDTO.setId(topping.getId());
        toppingDTO.setName(topping.getName());
        toppingDTO.setPrice(topping.getPrice());

        return toppingDTO;
    }

    public List<Topping> convertToEntityList(List<ToppingDTO> toppingDTOList) {

        return toppingDTOList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public List<ToppingDTO> convertToDtoList(List<Topping> toppingList) {

        return toppingList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
