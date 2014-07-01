package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.AdresaDAO;
import com.sprhib.model.Adresa;

@Service
@Transactional
public class AdresaService implements EntityService<Adresa> {
	
	@Autowired
	private AdresaDAO adresaDAO;

	public void addEntity(Adresa adresa) {
		adresaDAO.addEntity(adresa);		
	}

	public void updateEntity(Adresa adresa) {
		adresaDAO.updateEntity(adresa);
	}

	public Adresa getEntity(int id) {
		return adresaDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		adresaDAO.deleteEntity(id);
	}

	public List<Adresa> getEntites() {
		return adresaDAO.getEntites();
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
