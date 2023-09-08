package com.burak.fos.webcontroller;

import com.burak.fos.dto.SidesDTO;
import com.burak.fos.service.SidesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SidesWebController {

    @Autowired
    private SidesService sidesService;

    @GetMapping("/sides")
    public String getAllSides(Model model) {

        List<SidesDTO> sidesDTOList = sidesService.findAllSides().getBody();
        model.addAttribute("sides",sidesDTOList);
        return "sides";
    }
}
