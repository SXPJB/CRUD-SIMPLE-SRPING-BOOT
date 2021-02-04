package com.softitlan.capacitacionspring.repository;

import com.softitlan.capacitacionspring.model.GeneralDataVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDataRepository extends JpaRepository<GeneralDataVO,Integer> {
}
