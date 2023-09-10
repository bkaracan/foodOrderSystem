package com.burak.fos.bean.topping;

import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Topping;
import com.burak.fos.mapper.ToppingDTOMapper;
import com.burak.fos.repository.ToppingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FindToppingBean {

    private final ToppingRepository toppingRepository;
    private final ToppingDTOMapper toppingDTOMapper;

    @Autowired
    public FindToppingBean(ToppingRepository toppingRepository, ToppingDTOMapper toppingDTOMapper) {
        this.toppingRepository = toppingRepository;
        this.toppingDTOMapper = toppingDTOMapper;
    }

    public ResponseEntity<List<ToppingDTO>> findAllToppings() {

        try{

            List<Topping> toppingList = toppingRepository.findAll();
            if(!toppingList.isEmpty()) {
                List<ToppingDTO> toppingDTOList = toppingDTOMapper.convertToDtoList(toppingList);
                return new ResponseEntity<>(toppingDTOList, HttpStatus.FOUND);
            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<ToppingDTO> findToppingById(Long id) {

        try {
            Optional<Topping> optionalTopping = toppingRepository.findById(id);
            if(optionalTopping.isPresent()) {
                Topping topping = optionalTopping.get();
                ToppingDTO toppingDTO = toppingDTOMapper.convertToDto(topping);
                return new ResponseEntity<>(toppingDTO, HttpStatus.FOUND);
            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
