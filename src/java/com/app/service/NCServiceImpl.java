/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.dao.NCDao;
import com.app.model.NC;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roman
 */
@Service("NCService")//forse minuscolo dip
@Transactional
public class NCServiceImpl implements NCService {
    
    @Autowired
    private NCDao dao;
     
    public NC findById(int id) {
        return dao.findById(id);
    }
 
    /*@Override
    public void saveDipedenti(NC dip) {
        dao.saveCategoria(dip);
    }

    @Override
    public void updateDipedenti(NC dip) {
        Dipedenti entity = dao.findById(dip.getId());
        if(entity!=null){
            entity.setCategoria(dip.getCategoria());
            entity.setDescrizione(dip.getDescrizione());
        }
    }

    @Override
    public void deleteNC(int id) {
        dao.deleteCategoria(id);
    }
*/
    @Override
    public List<NC> findAll() {
        return dao.findAll();
    }
    public List<NC> findNCResponsabileById(int id) {
        return dao.findNCResponsabileById(id);
    }
}