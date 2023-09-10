package com.burak.fos.service.impl;

import com.burak.fos.bean.userselection.ToppingSelectionForHamburgerBean;
import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.UserSelectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserSelectionServiceImpl implements UserSelectionService {

    @Autowired
    private final ToppingSelectionForHamburgerBean toppingSelectionForHamburgerBean;

    public UserSelectionServiceImpl(ToppingSelectionForHamburgerBean toppingSelectionForHamburgerBean) {
        this.toppingSelectionForHamburgerBean = toppingSelectionForHamburgerBean;
    }

    @Override
    public ResponseEntity<BurgerDTO> getUserSelection(Long burgerId, List<Long> toppingIds) {
        return toppingSelectionForHamburgerBean.getUserSelection(burgerId, toppingIds);
    }
}
