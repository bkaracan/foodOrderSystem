package com.burak.fos.service.impl;

import com.burak.fos.bean.sides.FindSidesBean;
import com.burak.fos.bean.sides.SaveSidesBean;
import com.burak.fos.bean.sides.UpdateSidesBean;
import com.burak.fos.dto.SidesDTO;
import com.burak.fos.service.SidesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SidesServiceImpl implements SidesService {

    @Autowired
    private final SaveSidesBean saveSidesBean;
    private final FindSidesBean findSidesBean;
    private final UpdateSidesBean updateSidesBean;

    public SidesServiceImpl(SaveSidesBean saveSidesBean, FindSidesBean findSidesBean, UpdateSidesBean updateSidesBean) {
        this.saveSidesBean = saveSidesBean;
        this.findSidesBean = findSidesBean;
        this.updateSidesBean = updateSidesBean;
    }

    @Override
    public ResponseEntity<SidesDTO> saveSides(SidesDTO sidesDTO) {

        return saveSidesBean.saveSides(sidesDTO);

    }

    @Override
    public ResponseEntity<List<SidesDTO>> findAllSides() {

        return findSidesBean.findAllSides();
    }

    @Override
    public ResponseEntity<SidesDTO> updateSides(SidesDTO sidesDTO) {
        return updateSidesBean.update(sidesDTO);
    }

    @Override
    public ResponseEntity<SidesDTO> findSidesById(Long id) {
        return  findSidesBean.findSidesById(id);
    }

    @Override
    public ResponseEntity<List<SidesDTO>> saveSidesList(List<SidesDTO> sidesDTOList) {
        return saveSidesBean.saveSidesList(sidesDTOList);
    }
}
