package com.burak.fos.bean.beverage;

import com.burak.fos.dto.BeverageDTO;
import com.burak.fos.entity.Beverage;
import com.burak.fos.mapper.BeverageDTOMapper;
import com.burak.fos.repository.BeverageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FindBeverageBean {


    private final BeverageRepository beverageRepository;
    private final BeverageDTOMapper beverageDTOMapper;

    @Autowired
    public FindBeverageBean(BeverageRepository beverageRepository, BeverageDTOMapper beverageDTOMapper) {
        this.beverageRepository = beverageRepository;
        this.beverageDTOMapper = beverageDTOMapper;
    }

    public ResponseEntity<List<BeverageDTO>> findAllBeverages() {

        try {

            List<Beverage> beverages = beverageRepository.findAll(Sort.by(Sort.Order.asc("name"),Sort.Order.asc("size")));
            List<BeverageDTO> beverageDTOList = beverageDTOMapper.convertToDtoList(beverages);
            return new ResponseEntity<>(beverageDTOList, HttpStatus.FOUND);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<BeverageDTO> findBeverageById(Long id) {

        try {

            Optional<Beverage> beverageOptional = beverageRepository.findById(id);

            if(beverageOptional.isPresent()) {
                Beverage beverage = beverageOptional.get();
                return new ResponseEntity<>(beverageDTOMapper.convertToDto(beverage), HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
