package com.burak.fos.service;

import com.burak.fos.dto.BurgerDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserSelectionService {

    ResponseEntity<BurgerDTO> getUserSelection(Long burgerId, List<Long> toppingIds);
}
