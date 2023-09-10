package com.burak.fos.bean.userselection;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Burger;
import com.burak.fos.entity.Topping;
import com.burak.fos.mapper.BurgerDTOMapper;
import com.burak.fos.mapper.ToppingDTOMapper;
import com.burak.fos.repository.BurgerRepository;
import com.burak.fos.repository.ToppingRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ToppingSelectionForHamburgerBean {

    @Autowired
    private final BurgerRepository burgerRepository;
    private final ToppingRepository toppingRepository;
    private final BurgerDTOMapper burgerDTOMapper;
    private final ToppingDTOMapper toppingDTOMapper;

    public ToppingSelectionForHamburgerBean(BurgerRepository burgerRepository, ToppingRepository toppingRepository, BurgerDTOMapper burgerDTOMapper, ToppingDTOMapper toppingDTOMapper) {
        this.burgerRepository = burgerRepository;
        this.toppingRepository = toppingRepository;
        this.burgerDTOMapper = burgerDTOMapper;
        this.toppingDTOMapper = toppingDTOMapper;
    }

    public ResponseEntity<BurgerDTO> getUserSelection(Long burgerId, List<Long> toppingIds) {

        try {
            Burger selectedBurger = burgerRepository.findById(burgerId).orElse(null);
            List<Topping> selectedToppings = toppingRepository.findAllById(toppingIds);

            if (selectedBurger == null || selectedToppings.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }

            BurgerDTO burgerDTO = burgerDTOMapper.convertToDto(selectedBurger);
            List<ToppingDTO> toppingDTOs = selectedToppings.stream()
                    .map(toppingDTOMapper::convertToDto)
                    .collect(Collectors.toList());
            burgerDTO.setToppings(toppingDTOs);

            return ResponseEntity.ok(burgerDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}


