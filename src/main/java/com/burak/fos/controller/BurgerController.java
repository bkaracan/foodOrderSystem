package com.burak.fos.controller;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.BurgerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
