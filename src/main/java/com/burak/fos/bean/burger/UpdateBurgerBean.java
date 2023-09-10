package com.burak.fos.bean.burger;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.entity.Burger;
import com.burak.fos.mapper.BurgerDTOMapper;
import com.burak.fos.repository.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateBurgerBean {

    private final BurgerRepository burgerRepository;
    private final FindBurgerBean findBurgerBean;
    private final BurgerDTOMapper burgerDTOMapper;

    @Autowired
    public UpdateBurgerBean(BurgerRepository burgerRepository, FindBurgerBean findBurgerBean, BurgerDTOMapper burgerDTOMapper) {
        this.burgerRepository = burgerRepository;
        this.findBurgerBean = findBurgerBean;
        this.burgerDTOMapper = burgerDTOMapper;
    }

    @Transactional
    public ResponseEntity<BurgerDTO> updateBurger(BurgerDTO burgerDTO) {

        try {

            ResponseEntity<BurgerDTO> response = findBurgerBean.findBurgerById(burgerDTO.getId());

            if(response.getBody() != null) {

                Burger updatedBurger = burgerDTOMapper.convertToEntity(burgerDTO);
                burgerRepository.save(updatedBurger);
                return new ResponseEntity<>(burgerDTOMapper.convertToDto(updatedBurger), HttpStatus.OK);
            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
