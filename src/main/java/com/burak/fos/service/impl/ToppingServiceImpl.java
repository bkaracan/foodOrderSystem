package com.burak.fos.service.impl;

import com.burak.fos.bean.topping.FindToppingBean;
import com.burak.fos.bean.topping.SaveToppingBean;
import com.burak.fos.bean.topping.UpdateToppingBean;
import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.service.ToppingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToppingServiceImpl implements ToppingService {

    private final SaveToppingBean saveToppingBean;
    private final FindToppingBean findToppingBean;
    private final UpdateToppingBean updateToppingBean;

    @Autowired
    public ToppingServiceImpl(SaveToppingBean saveToppingBean, FindToppingBean findToppingBean, UpdateToppingBean updateToppingBean) {
        this.saveToppingBean = saveToppingBean;
        this.findToppingBean = findToppingBean;
        this.updateToppingBean = updateToppingBean;
    }

    public ResponseEntity<ToppingDTO> saveTopping(ToppingDTO toppingDTO) {

        return saveToppingBean.saveTopping(toppingDTO);
    }

    public ResponseEntity<List<ToppingDTO>> saveToppingList(List<ToppingDTO> toppingDTOList) {

        return saveToppingBean.saveToppingList(toppingDTOList);
    }

    @Override
    public ResponseEntity<List<ToppingDTO>> findAllToppings() {
        return findToppingBean.findAllToppings();
    }

    @Override
    public ResponseEntity<ToppingDTO> findToppingById(Long id) {
        return findToppingBean.findToppingById(id);
    }

    @Override
    public ResponseEntity<ToppingDTO> updateTopping(ToppingDTO toppingDTO) {
        return updateToppingBean.updateTopping(toppingDTO);
    }
}
