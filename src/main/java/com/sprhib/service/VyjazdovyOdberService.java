package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.VyjazdovyOdberDAO;
import com.sprhib.model.VyjazdovyOdber;

@Service
@Transactional
public class VyjazdovyOdberService implements EntityVyjazdovyOdberService<VyjazdovyOdber> {
	
	@Autowired
	private VyjazdovyOdberDAO vyjazdovyOdberDAO;

	public void addEntity(VyjazdovyOdber vyjazdovyOdber) {
		vyjazdovyOdberDAO.addEntity(vyjazdovyOdber);		
	}

	public void updateEntity(VyjazdovyOdber vyjazdovyOdber) {
		vyjazdovyOdberDAO.updateEntity(vyjazdovyOdber);
	}

	public VyjazdovyOdber getEntity(int id) {
		return vyjazdovyOdberDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		vyjazdovyOdberDAO.deleteEntity(id);
	}

	public List<VyjazdovyOdber> getEntites() {
		return vyjazdovyOdberDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VyjazdovyOdber> getVyjazdyOdDnes() {
        return vyjazdovyOdberDAO.getVyjazdyOdDnes();
    }

}
