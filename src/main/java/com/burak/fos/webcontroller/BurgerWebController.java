package com.burak.fos.webcontroller;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.BurgerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BurgerWebController {

    @Autowired
    private BurgerService burgerService;

    @GetMapping("/burgers")
    public String getAllBurgers(Model model) {

        List<BurgerDTO> burgerDTOList = burgerService.findAllBurgers().getBody();
        model.addAttribute("burgers", burgerDTOList);
        return "burgers";
    }
}
