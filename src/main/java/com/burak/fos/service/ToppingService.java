package com.burak.fos.service;

import com.burak.fos.dto.ToppingDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ToppingService {

    ResponseEntity<ToppingDTO> saveTopping(ToppingDTO toppingDTO);

    ResponseEntity<List<ToppingDTO>> saveToppingList(List<ToppingDTO> toppingDTOList);

    ResponseEntity<List<ToppingDTO>> findAllToppings();

    ResponseEntity<ToppingDTO> findToppingById(Long id);

    ResponseEntity<ToppingDTO> updateTopping(ToppingDTO toppingDTO);
}
