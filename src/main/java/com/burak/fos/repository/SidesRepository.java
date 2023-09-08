package com.burak.fos.repository;

import com.burak.fos.entity.Sides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SidesRepository extends JpaRepository<Sides, Long> {

}
