package com.burak.fos.mapper;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.entity.Beverage;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BeverageDTOMapper {


    public Beverage convertToEntity(BeverageDTO beverageDTO) {

        Beverage beverage = new Beverage();
        beverage.setId(beverageDTO.getId());
        beverage.setName(beverageDTO.getName());
        beverage.setSize(beverageDTO.getSize());
        beverage.setPrice(beverageDTO.getPrice());
        return beverage;
    }

    public BeverageDTO convertToDto(Beverage beverage) {

        BeverageDTO beverageDTO = new BeverageDTO();
        beverageDTO.setId(beverage.getId());
        beverageDTO.setName(beverage.getName());
        beverageDTO.setSize(beverage.getSize());
        beverageDTO.setPrice(beverage.getPrice());

        return beverageDTO;
    }

    public List<Beverage> convertToEntityList(List<BeverageDTO> beverageDTOs) {

        return beverageDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public List<BeverageDTO> convertToDtoList(List<Beverage> beverages) {

        return beverages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


}
