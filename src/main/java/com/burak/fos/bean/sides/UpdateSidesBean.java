package com.burak.fos.bean.sides;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.entity.Sides;
import com.burak.fos.mapper.SidesDTOMapper;
import com.burak.fos.repository.SidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateSidesBean {

    private final SidesRepository sidesRepository;
    private final FindSidesBean findSidesBean;
    private final SidesDTOMapper sidesDTOMapper;

    @Autowired
    public UpdateSidesBean(SidesRepository sidesRepository, FindSidesBean findSidesBean, SidesDTOMapper sidesDTOMapper) {
        this.sidesRepository = sidesRepository;
        this.findSidesBean = findSidesBean;
        this.sidesDTOMapper = sidesDTOMapper;
    }

    @Transactional
    public ResponseEntity<SidesDTO> update(SidesDTO sidesDTO) {

        try {

            ResponseEntity<SidesDTO> response = findSidesBean.findSidesById(sidesDTO.getId());

            if(response.getBody() != null) {

                Sides updatedSides = sidesDTOMapper.convertToEntity(sidesDTO);
                sidesRepository.save(updatedSides);
                return new ResponseEntity<>(sidesDTOMapper.convertToDto(updatedSides), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
