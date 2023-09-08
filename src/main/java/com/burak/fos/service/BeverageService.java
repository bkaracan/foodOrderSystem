package com.burak.fos.service;

import com.burak.fos.dto.BeverageDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BeverageService {

    ResponseEntity<BeverageDTO> saveBeverage(BeverageDTO beverageDTO);

    ResponseEntity<List<BeverageDTO>> findAllBeverages();

    ResponseEntity<BeverageDTO> findBeverageById(Long id);

    ResponseEntity<BeverageDTO> updateBeverage(BeverageDTO beverageDTO);

    ResponseEntity<List<BeverageDTO>> saveBeverageList(List<BeverageDTO> beverageDTOList);
}
