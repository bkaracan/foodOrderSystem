package com.burak.fos.service.impl;

import com.burak.fos.bean.topping.SaveToppingBean;
import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.service.ToppingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToppingServiceImpl implements ToppingService {

    private final SaveToppingBean saveToppingBean;

    @Autowired
    public ToppingServiceImpl(SaveToppingBean saveToppingBean) {
        this.saveToppingBean = saveToppingBean;
    }

    public ResponseEntity<ToppingDTO> saveTopping(ToppingDTO toppingDTO) {

        return saveToppingBean.saveTopping(toppingDTO);
    }

    public ResponseEntity<List<ToppingDTO>> saveToppingList(List<ToppingDTO> toppingDTOList) {

        return saveToppingBean.saveToppingList(toppingDTOList);
    }
}
