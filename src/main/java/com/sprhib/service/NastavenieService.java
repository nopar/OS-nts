package com.sprhib.service;

import com.sprhib.dao.NastavenieDAO;
import com.sprhib.model.Nastavenie;
import com.sprhib.model.Pouzivatelia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NastavenieService implements EntityNastavenieService<Nastavenie> {
	
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

    public Integer getKonkretny() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pouzivatelia> getPouzivatelaList(Integer nickID) {
        return nastavenieDAO.getPouzivatelaList(nickID);

    }

    
    public List<Nastavenie> getMojeSetings(Integer nickID) {
        return nastavenieDAO.getMojeSetings(nickID);
    }

}
