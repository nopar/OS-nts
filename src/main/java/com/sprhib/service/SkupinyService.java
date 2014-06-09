package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.SkupinyDAO;
import com.sprhib.model.Skupiny;

@Service
@Transactional
public class SkupinyService implements EntityService<Skupiny> {
	
	@Autowired
	private SkupinyDAO skupinaDAO;

	public void addEntity(Skupiny stat) {
		skupinaDAO.addEntity(stat);		
	}

	public void updateEntity(Skupiny stat) {
		skupinaDAO.updateEntity(stat);
	}

	public Skupiny getEntity(int id) {
		return skupinaDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		skupinaDAO.deleteEntity(id);
	}

	public List<Skupiny> getEntites() {
		return skupinaDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
