package com.burak.fos.service;

import com.burak.fos.dto.BurgerDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BurgerService {

    public ResponseEntity<BurgerDTO> saveBurger(BurgerDTO burgerDTO);

    public ResponseEntity<List<BurgerDTO>> saveBurgerList(List<BurgerDTO> burgerDTOList);
}
