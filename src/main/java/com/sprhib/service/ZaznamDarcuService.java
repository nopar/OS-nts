package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.ZaznamDarcuDAO;
import com.sprhib.model.ZaznamDarcu;

@Service
@Transactional
public class ZaznamDarcuService implements EntityService<ZaznamDarcu> {
	
	@Autowired
	private ZaznamDarcuDAO zaznamDarcuDAO;

	public void addEntity(ZaznamDarcu zaznamDarcu) {
		zaznamDarcuDAO.addEntity(zaznamDarcu);		
	}

	public void updateEntity(ZaznamDarcu zaznamDarcu) {
		zaznamDarcuDAO.updateEntity(zaznamDarcu);
	}

	public ZaznamDarcu getEntity(int id) {
		return zaznamDarcuDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		zaznamDarcuDAO.deleteEntity(id);
	}

	public List<ZaznamDarcu> getEntites() {
		return zaznamDarcuDAO.getEntites();
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
