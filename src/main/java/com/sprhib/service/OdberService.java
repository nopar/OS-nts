package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.OdberDAOImpl;
import com.sprhib.model.Odber;

@Service
@Transactional
public class OdberService implements EntityService<Odber> {
	
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
        
        public Integer getKonkretny() {
		return odberDAO.getOdbery();
	}

  

}
