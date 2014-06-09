package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.MestoDAO;
import com.sprhib.model.Mesto;

@Service
@Transactional
public class MestoService implements EntityService<Mesto> {
	
	@Autowired
	private MestoDAO mestoDAO;

	public void addEntity(Mesto stat) {
		mestoDAO.addEntity(stat);		
	}

	public void updateEntity(Mesto stat) {
		mestoDAO.updateEntity(stat);
	}

	public Mesto getEntity(int id) {
		return mestoDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		mestoDAO.deleteEntity(id);
	}

	public List<Mesto> getEntites() {
		return mestoDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
