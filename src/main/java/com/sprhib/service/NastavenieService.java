package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.NastavenieDAO;
import com.sprhib.model.Nastavenie;

@Service
@Transactional
public class NastavenieService implements EntityService<Nastavenie> {
	
	@Autowired
	private NastavenieDAO nastavenieDAO;

	public void addEntity(Nastavenie nastavenie) {
		nastavenieDAO.addEntity(nastavenie);		
	}

	public void updateEntity(Nastavenie nastavenie) {
		nastavenieDAO.updateEntity(nastavenie);
	}

	public Nastavenie getEntity(int id) {
		return nastavenieDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		nastavenieDAO.deleteEntity(id);
	}

	public List<Nastavenie> getEntites() {
		return nastavenieDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
