package com.burak.fos.webcontroller;

import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.service.BurgerService;
import com.burak.fos.service.ToppingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BurgerWebController {

    @Autowired
    private BurgerService burgerService;

    @Autowired
    private ToppingService toppingService;

    @GetMapping("/burgers")
    public String getAllBurgers(Model model) {

        List<BurgerDTO> burgerDTOList = burgerService.findAllBurgers().getBody();
        model.addAttribute("burgers", burgerDTOList);
        return "burgers";
    }

    @GetMapping("/toppings")
    public String showToppings(@RequestParam Long burgerId, Model model) {
        BurgerDTO selectedBurger = burgerService.findBurgerById(burgerId).getBody();
        model.addAttribute("selectedBurger", selectedBurger);
        List<ToppingDTO> toppingDTOList = toppingService.findAllToppings().getBody();
        model.addAttribute("toppings", toppingDTOList);
        return "toppings";
    }
}
