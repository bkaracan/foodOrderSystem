package com.burak.fos.controller;

import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.service.ToppingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toppings")
public class ToppingController {

    private final ToppingService toppingService;

    @Autowired
    public ToppingController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ToppingDTO> saveTopping(@RequestBody ToppingDTO toppingDTO) {

        return toppingService.saveTopping(toppingDTO);
    }

    @PostMapping(value = "/saveList")
    public  ResponseEntity<List<ToppingDTO>> saveToppingList(@RequestBody List<ToppingDTO> toppingDTOList) {

        return toppingService.saveToppingList(toppingDTOList);

    }
}
