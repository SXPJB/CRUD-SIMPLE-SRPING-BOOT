package com.softitlan.capacitacionspring.service;

import com.softitlan.capacitacionspring.model.GeneralDataVO;

import java.util.List;
import java.util.Map;

public interface GeneralDataService {

    void insert(GeneralDataVO generalDataVO);
    void update(int id, Map<String,Object> data);
    void delete(int id);
    List<GeneralDataVO> findAllPage(int page, int size);

}
