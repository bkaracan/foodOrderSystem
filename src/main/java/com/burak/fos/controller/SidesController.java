package com.burak.fos.controller;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.service.SidesService;
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
@RequestMapping("/sides")
public class SidesController {

    @Autowired
    private SidesService sidesService;


    @PostMapping(value = "/save")
    public ResponseEntity<SidesDTO> saveSides(@RequestBody SidesDTO sidesDTO) {

        return sidesService.saveSides(sidesDTO);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<SidesDTO>> findAllSides() {

        return sidesService.findAllSides();
    }

    @GetMapping(value = "/findById")
    public  ResponseEntity<SidesDTO> findSidesById(@RequestParam("id") Long id) {

        return sidesService.findSidesById(id);
    }

    @PostMapping(value = "/saveList")
    public ResponseEntity<List<SidesDTO>> savedSidesList(@RequestBody List<SidesDTO> sidesDTOList) {

        return sidesService.saveSidesList(sidesDTOList);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<SidesDTO> updateSides(@RequestBody SidesDTO sidesDTO) {

        return sidesService.updateSides(sidesDTO);
    }
}
