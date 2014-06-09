package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.NtsDAO;
import com.sprhib.model.Nts;

@Service
@Transactional
public class NtsService implements EntityService<Nts> {
	
	@Autowired
	private NtsDAO ntsDAO;

	public void addEntity(Nts nts) {
		ntsDAO.addEntity(nts);		
	}

	public void updateEntity(Nts nts) {
		ntsDAO.updateEntity(nts);
	}

	public Nts getEntity(int id) {
		return ntsDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		ntsDAO.deleteEntity(id);
	}

	public List<Nts> getEntites() {
		return ntsDAO.getEntites();
	}

    @Override
    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
