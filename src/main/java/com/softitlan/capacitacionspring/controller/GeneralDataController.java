package com.softitlan.capacitacionspring.controller;

import com.softitlan.capacitacionspring.model.GeneralDataVO;
import com.softitlan.capacitacionspring.service.GeneralDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generaldata")
public class GeneralDataController {
    private static final Logger LOG = LoggerFactory.getLogger(GeneralDataController.class);
    @Autowired
    private GeneralDataService service;

    @PostMapping("/inser")
    public ResponseEntity<Void> insert(@RequestBody GeneralDataVO vo){
        ResponseEntity<Void> res=null;
        try {
            service.insert(vo);
            res=new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch (Exception e){
            LOG.error("Algo paso");
            e.printStackTrace();
        }
        return  res;
    }
    /*
    * get eliminar (@RequestParam("id") int id) -> http://localhost:8080/generaldata/delete?id=1
    * get optener todos con la paginacion (@RequestParam("page") int page, @RequestParam("size") int size)
    * post acutalizar (@RequestParam("id") int id, @RequestBody Map<String,Object> data)
    * */
}
