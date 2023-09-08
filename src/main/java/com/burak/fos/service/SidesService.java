package com.burak.fos.service;

import com.burak.fos.dto.SidesDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface SidesService {

    ResponseEntity<SidesDTO> saveSides(SidesDTO sidesDTO);

    ResponseEntity<List<SidesDTO>> findAllSides();

    ResponseEntity<SidesDTO> updateSides(SidesDTO sidesDTO);

    ResponseEntity<SidesDTO> findSidesById(Long id);

    ResponseEntity<List<SidesDTO>> saveSidesList(List<SidesDTO> sidesDTOList);

}
