package com.burak.fos.bean.beverage;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.entity.Beverage;
import com.burak.fos.mapper.BeverageDTOMapper;
import com.burak.fos.repository.BeverageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveBeverageBean {

    private final BeverageRepository beverageRepository;
    private final BeverageDTOMapper beverageDTOMapper;

    @Autowired
    public SaveBeverageBean(BeverageRepository beverageRepository, BeverageDTOMapper beverageDTOMapper) {
        this.beverageRepository = beverageRepository;
        this.beverageDTOMapper = beverageDTOMapper;
    }

    @Transactional
    public ResponseEntity<BeverageDTO> saveBeverage(BeverageDTO beverageDTO) {

        try {

            Beverage beverage = beverageDTOMapper.convertToEntity(beverageDTO);
            Beverage savedBeverage = beverageRepository.save(beverage);
            return new ResponseEntity<>(beverageDTOMapper.convertToDto(savedBeverage), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional
    public ResponseEntity<List<BeverageDTO>> saveBeverageList(List<BeverageDTO> beverageDTOList) {

        try {

            List<Beverage> beverages = beverageDTOMapper.convertToEntityList(beverageDTOList);
            List<Beverage> savedBeverageList = beverageRepository.saveAll(beverages);
            return new ResponseEntity<>(beverageDTOMapper.convertToDtoList(savedBeverageList), HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
