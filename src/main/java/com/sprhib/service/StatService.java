package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.StatDAO;
import com.sprhib.model.Stat;

@Service
@Transactional
public class StatService implements EntityService<Stat> {

    @Autowired
    private StatDAO statDAO;

    public void addEntity(Stat stat) {
        statDAO.addEntity(stat);
    }

    public void updateEntity(Stat stat) {
        statDAO.updateEntity(stat);
    }

    public Stat getEntity(int id) {
        return statDAO.getEntity(id);
    }

    public void deleteEntity(int id) {
        statDAO.deleteEntity(id);
    }

    public List<Stat> getEntites() {
        return statDAO.getEntites();
    }

//    public List getListJSON() {
//        return statDAO.getListJSON();
//    }

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
