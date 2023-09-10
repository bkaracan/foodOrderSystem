package com.burak.fos.bean.burger;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.entity.Burger;
import com.burak.fos.mapper.BurgerDTOMapper;
import com.burak.fos.repository.BurgerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FindBurgerBean {

    private  final BurgerRepository burgerRepository;
    private final BurgerDTOMapper burgerDTOMapper;

    @Autowired
    public FindBurgerBean(BurgerRepository burgerRepository, BurgerDTOMapper burgerDTOMapper) {
        this.burgerRepository = burgerRepository;
        this.burgerDTOMapper = burgerDTOMapper;
    }

    public ResponseEntity<List<BurgerDTO>> findAllBurgers() {

        try {

            List<Burger> burgers = burgerRepository.findAll(Sort.by(Sort.Order.asc("name")));
            List<BurgerDTO> burgerDTOList = burgerDTOMapper.convertToDtoList(burgers);
            return new ResponseEntity<>(burgerDTOList, HttpStatus.FOUND);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<BurgerDTO> findBurgerById(Long id) {

        try {

            Optional<Burger> burgerOptional = burgerRepository.findById(id);

            if(burgerOptional.isPresent()) {

                Burger burger = burgerOptional.get();
                return new ResponseEntity<>(burgerDTOMapper.convertToDto(burger), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            }

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
