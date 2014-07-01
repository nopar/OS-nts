package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.KrvnaSkupinaDAO;
import com.sprhib.model.KrvnaSkupina;

@Service
@Transactional
public class KrvnaSkupinaService implements EntityService<KrvnaSkupina> {
	
	@Autowired
	private KrvnaSkupinaDAO krvnaSkupinaDAO;

	public void addEntity(KrvnaSkupina krvnaSkupina) {
		krvnaSkupinaDAO.addEntity(krvnaSkupina);		
	}

	public void updateEntity(KrvnaSkupina krvnaSkupina) {
		krvnaSkupinaDAO.updateEntity(krvnaSkupina);
	}

	public KrvnaSkupina getEntity(int id) {
		return krvnaSkupinaDAO.getEntity(id);
	}

	public void deleteEntity(int id) {
		krvnaSkupinaDAO.deleteEntity(id);
	}

	public List<KrvnaSkupina> getEntites() {
		return krvnaSkupinaDAO.getEntites();
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
