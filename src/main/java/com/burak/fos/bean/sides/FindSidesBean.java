package com.burak.fos.bean.sides;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.entity.Sides;
import com.burak.fos.mapper.SidesDTOMapper;
import com.burak.fos.repository.SidesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FindSidesBean {

    private final SidesRepository sidesRepository;
    private final SidesDTOMapper sidesDTOMapper;

    @Autowired
    public FindSidesBean(SidesRepository sidesRepository, SidesDTOMapper sidesDTOMapper) {
        this.sidesRepository = sidesRepository;
        this.sidesDTOMapper = sidesDTOMapper;
    }

    public ResponseEntity<List<SidesDTO>> findAllSides() {

        try {

            List<Sides> sidesList = sidesRepository.findAll(Sort.by(Sort.Order.asc("name"), Sort.Order.asc("kcal")));
            List<SidesDTO> sidesDTOList = sidesDTOMapper.convertToDtoList(sidesList);
            return new ResponseEntity<>(sidesDTOList, HttpStatus.FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<SidesDTO> findSidesById(Long id) {

        try {

            Optional<Sides> sidesOptional = sidesRepository.findById(id);

            if(sidesOptional.isPresent()) {

                Sides sides = sidesOptional.get();
                return new ResponseEntity<>(sidesDTOMapper.convertToDto(sides), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
