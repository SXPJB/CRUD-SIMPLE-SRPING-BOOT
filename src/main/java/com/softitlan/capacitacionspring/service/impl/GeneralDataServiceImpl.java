package com.softitlan.capacitacionspring.service.impl;

import com.softitlan.capacitacionspring.model.GeneralDataVO;
import com.softitlan.capacitacionspring.repository.GeneralDataRepository;
import com.softitlan.capacitacionspring.service.GeneralDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GeneralDataServiceImpl implements GeneralDataService {

    private static final Logger LOG = LoggerFactory.getLogger(GeneralDataServiceImpl.class);

    @Autowired
    private GeneralDataRepository repository;

    @Override
    public void insert(GeneralDataVO generalDataVO) {
        try {
            if(generalDataVO==null){
                LOG.error("El vo esta nulo");
                return;
            }
            //Logica
            generalDataVO.setId(0);
            repository.save(generalDataVO);
        }catch (Exception e){
            LOG.error("Algo paso");
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Map<String, Object> data) {
        try {
            Optional<GeneralDataVO> vo=repository.findById(id);
            if(!vo.isPresent()){
                LOG.info("No exsite el registro");
                return;
            }
            if(data.containsKey("name")){
                vo.get().setName(data.get("name").toString());
            }
            if(data.containsKey("surname")){
                vo.get().setSurname(data.get("surname").toString());
            }
            if(data.containsKey("datebrith")){
                vo.get().setDatebrith((Date)data.get("datebrith"));
            }
            if(data.containsKey("gender")){
                vo.get().setGender(data.get("gender").toString());
            }
            repository.save(vo.get());
        }catch (Exception e){
            LOG.error("Algo paso");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try{
            Optional<GeneralDataVO> vo=repository.findById(id);
            if(!vo.isPresent()){
                LOG.info("No exsite el registro");
                return;
            }
            repository.delete(vo.get());
        }catch (Exception e){
            LOG.error("Algo paso");
            e.printStackTrace();
        }
    }

    @Override
    public List<GeneralDataVO> findAllPage(int page, int size) {
        List<GeneralDataVO> dataVOList=null;
        try {
            Pageable pageable= PageRequest.of(page,size);
            dataVOList=repository.findAll(pageable).toList();
        }catch (Exception e){
            LOG.error("Algo paso");
            e.printStackTrace();
        }
        return dataVOList;
    }
}
