package com.sprhib.service;

import com.sprhib.dao.OdberDAOImpl;
import com.sprhib.model.Odber;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OdberService implements EntityOdberService<Odber> {

    @Autowired
    private OdberDAOImpl odberDAO;

    public void addEntity(Odber odber) {
        odberDAO.addEntity(odber);
    }

    public void updateEntity(Odber odber) {
        odberDAO.updateEntity(odber);
    }

    public Odber getEntity(int id) {
        return odberDAO.getEntity(id);
    }

    public void deleteEntity(int id) {
        odberDAO.deleteEntity(id);
    }

    public List<Odber> getEntites() {
        return odberDAO.getEntites();
    }

    public Integer getKonkretny(String hladanyNick) {
        return odberDAO.getOdbery(hladanyNick);
    }

    @Override
    public Integer getUserIDfromNick(String logNick) {
        return odberDAO.getUserIDfromNick(logNick);
    }
    
    public List<Odber> getMojeOdberyHistory(int nickID){
        return odberDAO.getOdberHistory(nickID);
    }

    @Override
    public List<Odber> getLastOdber(Integer nickID) {
        return odberDAO.getLastOdber(nickID);
    }

}
