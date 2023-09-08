package com.burak.fos.webcontroller;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.service.BeverageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeverageWebController {

    @Autowired
    private BeverageService beverageService;

    @GetMapping("/beverages")
    public String getAllBeverages(Model model) {

        List<BeverageDTO> beverages = beverageService.findAllBeverages().getBody();
        model.addAttribute("beverages", beverages);
        return "beverages";
    }

}
