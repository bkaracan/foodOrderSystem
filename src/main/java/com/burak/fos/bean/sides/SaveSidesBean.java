package com.burak.fos.bean.sides;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.entity.Sides;
import com.burak.fos.mapper.SidesDTOMapper;
import com.burak.fos.repository.SidesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SaveSidesBean {

    private final SidesRepository sidesRepository;
    private final SidesDTOMapper sidesDTOMapper;

    @Autowired
    public SaveSidesBean(SidesRepository sidesRepository, SidesDTOMapper sidesDTOMapper) {
        this.sidesRepository = sidesRepository;
        this.sidesDTOMapper = sidesDTOMapper;
    }

    public ResponseEntity<SidesDTO> saveSides(SidesDTO sidesDTO) {

        try {

            Sides sides = sidesDTOMapper.convertToEntity(sidesDTO);
            Sides savedSides = sidesRepository.save(sides);
            return new ResponseEntity<>(sidesDTOMapper.convertToDto(savedSides), HttpStatus.CREATED);

        } catch (Exception e) {

            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

    public ResponseEntity<List<SidesDTO>> saveSidesList(List<SidesDTO> sidesDTOs) {

        try {

            List<Sides> sidesList = sidesDTOMapper.convertToEntityList(sidesDTOs);
            List<Sides> savedSidesList = sidesRepository.saveAll(sidesList);
            return new ResponseEntity<>(sidesDTOMapper.convertToDtoList(savedSidesList), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
