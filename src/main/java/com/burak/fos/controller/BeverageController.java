package com.burak.fos.controller;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.service.BeverageService;
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
@RequestMapping("/beverage")
public class BeverageController {

    @Autowired
    private BeverageService beverageService;

    @PostMapping(value = "/save")
    public ResponseEntity<BeverageDTO> saveBeverage(@RequestBody BeverageDTO beverageDTO) {

        return beverageService.saveBeverage(beverageDTO);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<BeverageDTO>> findAllBeverages() {

        return beverageService.findAllBeverages();
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<BeverageDTO> findBeverageById(@RequestParam("id") Long id) {

        return beverageService.findBeverageById(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<BeverageDTO> updateBeverage(@RequestBody BeverageDTO beverageDTO) {

        return beverageService.updateBeverage(beverageDTO);
    }

    @PostMapping(value = "/saveList")
    public ResponseEntity<List<BeverageDTO>> saveBeverageList(@RequestBody List<BeverageDTO> beverageDTOList) {

        return beverageService.saveBeverageList(beverageDTOList);
    }

}
