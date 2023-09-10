package com.burak.fos.controller;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.BurgerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    @Autowired
    private BurgerService burgerService;

    @PostMapping(value = "/save")
    public ResponseEntity<BurgerDTO> saveBurger(@RequestBody BurgerDTO burgerDTO) {

        return burgerService.saveBurger(burgerDTO);
    }

    @PostMapping(value = "/saveList")
    public ResponseEntity<List<BurgerDTO>> saveBurgerList(@RequestBody List<BurgerDTO> burgerDTOList) {

        return burgerService.saveBurgerList(burgerDTOList);
    }

    @GetMapping
    public ResponseEntity<List<BurgerDTO>> findAllBurgers() {

        return burgerService.findAllBurgers();
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<BurgerDTO> findBurgerById(@RequestParam("id") Long id) {

        return burgerService.findBurgerById(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<BurgerDTO> updateBurger(@RequestBody BurgerDTO burgerDTO) {

        return burgerService.updateBurger(burgerDTO);
    }

}
