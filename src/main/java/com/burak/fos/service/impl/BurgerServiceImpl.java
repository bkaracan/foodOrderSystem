package com.burak.fos.service.impl;

import com.burak.fos.bean.burger.SaveBurgerBean;
import com.burak.fos.dto.BurgerDTO;
import com.burak.fos.service.BurgerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BurgerServiceImpl implements BurgerService {

    @Autowired
    private final SaveBurgerBean saveBurgerBean;

    public BurgerServiceImpl(SaveBurgerBean saveBurgerBean) {
        this.saveBurgerBean = saveBurgerBean;
    }

    @Override
    public ResponseEntity<BurgerDTO> saveBurger(BurgerDTO burgerDTO) {
        return saveBurgerBean.saveBurger(burgerDTO);
    }

    @Override
    public ResponseEntity<List<BurgerDTO>> saveBurgerList(List<BurgerDTO> burgerDTOList) {
        return saveBurgerBean.saveBurgerList(burgerDTOList);
    }
}
