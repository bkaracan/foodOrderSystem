package com.burak.fos.bean.burger;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.entity.Burger;
import com.burak.fos.mapper.BurgerDTOMapper;
import com.burak.fos.repository.BurgerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SaveBurgerBean {

    private final BurgerRepository burgerRepository;
    private final BurgerDTOMapper burgerDTOMapper;

    @Autowired
    public SaveBurgerBean(BurgerRepository burgerRepository, BurgerDTOMapper burgerDTOMapper) {
        this.burgerRepository = burgerRepository;
        this.burgerDTOMapper = burgerDTOMapper;
    }

    public ResponseEntity<BurgerDTO> saveBurger(BurgerDTO burgerDTO) {

        try {

            Burger burger = burgerDTOMapper.convertToEntity(burgerDTO);
            Burger savedBurger = burgerRepository.save(burger);
            return new ResponseEntity<>(burgerDTOMapper.convertToDto(savedBurger), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<BurgerDTO>> saveBurgerList(List<BurgerDTO> burgerDTOList) {

        try {

            List<Burger> burgers = burgerDTOMapper.convertToEntityList(burgerDTOList);
            List<Burger> savedBurgers = burgerRepository.saveAll(burgers);
            return new ResponseEntity<>(burgerDTOMapper.convertToDtoList(savedBurgers), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
