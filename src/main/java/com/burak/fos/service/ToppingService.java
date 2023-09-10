package com.burak.fos.service;

import com.burak.fos.dto.ToppingDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ToppingService {

    public ResponseEntity<ToppingDTO> saveTopping(ToppingDTO toppingDTO);

    public ResponseEntity<List<ToppingDTO>> saveToppingList(List<ToppingDTO> toppingDTOList);
 }
