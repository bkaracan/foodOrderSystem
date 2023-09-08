package com.burak.fos.bean.beverage;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.entity.Beverage;
import com.burak.fos.mapper.BeverageDTOMapper;
import com.burak.fos.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateBeverageBean {

    private final BeverageRepository beverageRepository;
    private final FindBeverageBean findBeverageBean;
    private final BeverageDTOMapper beverageDTOMapper;

    @Autowired
    public UpdateBeverageBean(BeverageRepository beverageRepository, FindBeverageBean findBeverageBean, BeverageDTOMapper beverageDTOMapper) {
        this.beverageRepository = beverageRepository;
        this.findBeverageBean = findBeverageBean;
        this.beverageDTOMapper = beverageDTOMapper;
    }

    @Transactional
    public ResponseEntity<BeverageDTO> update(BeverageDTO beverageDTO) {

        try {

            ResponseEntity<BeverageDTO> response = findBeverageBean.findBeverageById(beverageDTO.getId());

            if(response.getBody() != null) {

                Beverage updatedBeverage = beverageDTOMapper.convertToEntity(beverageDTO);
                beverageRepository.save(updatedBeverage);
                return new ResponseEntity<>(beverageDTOMapper.convertToDto(updatedBeverage), HttpStatus.OK);
            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
