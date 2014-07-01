package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.KrajDAO;
import com.sprhib.model.Kraj;

@Service
@Transactional
public class KrajService implements EntityService<Kraj> {
	
	@Autowired
	private KrajDAO krajDAO;

	public void addEntity(Kraj kraj) {
		krajDAO.addEntity(kraj);		
	}

	public void updateEntity(Kraj kraj) {
		krajDAO.updateEntity(kraj);
	}

	public Kraj getEntity(int id) {
		return krajDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		krajDAO.deleteEntity(id);
	}

	public List<Kraj> getEntites() {
		return krajDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getLekars() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
