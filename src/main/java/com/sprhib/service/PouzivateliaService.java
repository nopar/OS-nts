package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.PouzivateliaDAO;
import com.sprhib.model.Pouzivatelia;

@Service
@Transactional
public class PouzivateliaService implements EntityService<Pouzivatelia> {
	
	@Autowired
	private PouzivateliaDAO pouzivateliaDAO;

	public void addEntity(Pouzivatelia pouzivatelia) {
		pouzivateliaDAO.addEntity(pouzivatelia);		
	}

	public void updateEntity(Pouzivatelia pouzivatelia) {
		pouzivateliaDAO.updateEntity(pouzivatelia);
	}

	public Pouzivatelia getEntity(int id) {
		return pouzivateliaDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		pouzivateliaDAO.deleteEntity(id);
	}

	public List<Pouzivatelia> getEntites() {
		return pouzivateliaDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
