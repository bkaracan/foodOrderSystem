package com.burak.fos.controller;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.UserSelectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSelectionController {

    @Autowired
    private final UserSelectionService userSelectionService;

    public UserSelectionController(UserSelectionService userSelectionService) {
        this.userSelectionService = userSelectionService;
    }

    @GetMapping("/user/selection/{burgerId}")
    public ResponseEntity<BurgerDTO> getUserSelection(@PathVariable Long burgerId, @RequestParam List<Long> toppingIds) {

        return userSelectionService.getUserSelection(burgerId, toppingIds);
    }
}
