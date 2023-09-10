package com.burak.fos.bean.topping;

import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Topping;
import com.burak.fos.mapper.ToppingDTOMapper;
import com.burak.fos.repository.ToppingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveToppingBean {

    private final ToppingRepository toppingRepository;
    private final ToppingDTOMapper toppingDTOMapper;

    @Autowired
    public SaveToppingBean(ToppingRepository toppingRepository, ToppingDTOMapper toppingDTOMapper) {
        this.toppingRepository = toppingRepository;
        this.toppingDTOMapper = toppingDTOMapper;
    }

    @Transactional
    public ResponseEntity<ToppingDTO> saveTopping(ToppingDTO toppingDTO) {

        try {

            Topping topping = toppingDTOMapper.convertToEntity(toppingDTO);
            Topping savedTopping = toppingRepository.save(topping);
            return new ResponseEntity<>(toppingDTOMapper.convertToDto(savedTopping), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<List<ToppingDTO>> saveToppingList(List<ToppingDTO> toppingDTOList) {

        try {

            List<Topping> toppings = toppingDTOMapper.convertToEntityList(toppingDTOList);
            List<Topping> savedToppingList = toppingRepository.saveAll(toppings);
            return new ResponseEntity<>(toppingDTOMapper.convertToDtoList(savedToppingList), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
