package com.burak.fos.service.impl;

import com.burak.fos.bean.beverage.FindBeverageBean;
import com.burak.fos.bean.beverage.SaveBeverageBean;
import com.burak.fos.bean.beverage.UpdateBeverageBean;
import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.service.BeverageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BeverageServiceImpl implements BeverageService {

    @Autowired
    private final SaveBeverageBean saveBeverageBean;
    private final FindBeverageBean findBeverageBean;
    private final UpdateBeverageBean updateBeverageBean;

    public BeverageServiceImpl(SaveBeverageBean saveBeverageBean, FindBeverageBean findBeverageBean, UpdateBeverageBean updateBeverageBean) {
        this.saveBeverageBean = saveBeverageBean;
        this.findBeverageBean = findBeverageBean;
        this.updateBeverageBean = updateBeverageBean;
    }

    @Override
    public ResponseEntity<BeverageDTO> saveBeverage(BeverageDTO beverageDTO) {

       return saveBeverageBean.saveBeverage(beverageDTO);
    }

    @Override
    public ResponseEntity<List<BeverageDTO>> findAllBeverages() {

        return  findBeverageBean.findAllBeverages();
    }

    @Override
    public ResponseEntity<BeverageDTO> findBeverageById(Long id) {

        return findBeverageBean.findBeverageById(id);
    }

    @Override
    public ResponseEntity<BeverageDTO> updateBeverage(BeverageDTO beverageDTO) {
        return updateBeverageBean.update(beverageDTO);
    }

    @Override
    public ResponseEntity<List<BeverageDTO>> saveBeverageList(List<BeverageDTO> beverageDTOList) {
        return saveBeverageBean.saveBeverageList(beverageDTOList);
    }

}
