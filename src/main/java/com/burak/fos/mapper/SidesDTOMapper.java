package com.burak.fos.mapper;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.entity.Sides;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SidesDTOMapper {

    public Sides convertToEntity(SidesDTO sidesDTO) {

        Sides sides = new Sides();
        sides.setId(sidesDTO.getId());
        sides.setName(sidesDTO.getName());
        sides.setSize(sidesDTO.getSize());
        sides.setKcal(sidesDTO.getKcal());
        sides.setCarbonhydrate(sidesDTO.getCarbonhydrate());
        sides.setFat(sidesDTO.getFat());
        sides.setProtein(sidesDTO.getProtein());
        sides.setPrice(sidesDTO.getPrice());
        return sides;
    }

    public SidesDTO convertToDto(Sides sides) {

        return SidesDTO.builder()
                .id(sides.getId())
                .name(sides.getName())
                .size(sides.getSize())
                .kcal(sides.getKcal())
                .carbonhydrate(sides.getCarbonhydrate())
                .fat(sides.getFat())
                .protein(sides.getProtein())
                .price(sides.getPrice())
                .build();
    }

    public List<Sides> convertToEntityList(List<SidesDTO> sidesDTOs) {

        return sidesDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    public List<SidesDTO> convertToDtoList(List<Sides> sidesList) {

        return sidesList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
