package com.burak.fos.bean.topping;

import com.burak.fos.dto.ToppingDTO;
import com.burak.fos.entity.Topping;
import com.burak.fos.mapper.ToppingDTOMapper;
import com.burak.fos.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateToppingBean {

    private final ToppingRepository toppingRepository;
    private final FindToppingBean findToppingBean;
    private final ToppingDTOMapper toppingDTOMapper;

    @Autowired
    public UpdateToppingBean(ToppingRepository toppingRepository, FindToppingBean findToppingBean, ToppingDTOMapper toppingDTOMapper) {
        this.toppingRepository = toppingRepository;
        this.findToppingBean = findToppingBean;
        this.toppingDTOMapper = toppingDTOMapper;
    }


    @Transactional
    public ResponseEntity<ToppingDTO> updateTopping(ToppingDTO toppingDTO) {

        try {

            ResponseEntity<ToppingDTO> response = findToppingBean.findToppingById(toppingDTO.getId());

            if(response.getBody() != null) {

                Topping updatedTopping = toppingDTOMapper.convertToEntity(toppingDTO);
                toppingRepository.save(updatedTopping);
                return new ResponseEntity<>(toppingDTOMapper.convertToDto(updatedTopping), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
