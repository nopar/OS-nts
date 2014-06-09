package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.KrvnaSkupina;

@Repository
public class KrvnaSkupinaDAO implements EntityDAO<KrvnaSkupina> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(KrvnaSkupina krvnaSkupina) {
		getCurrentSession().save(krvnaSkupina);
	}

	public void updateEntity(KrvnaSkupina krvnaSkupina) {
		KrvnaSkupina krvnaSkupinaToUpdate = getEntity(krvnaSkupina.getIdKrvnaSkupina());
		krvnaSkupinaToUpdate.setTypKrvi(krvnaSkupina.getTypKrvi());
                
		getCurrentSession().update(krvnaSkupinaToUpdate);		
	}

	public KrvnaSkupina getEntity(int id) {
		KrvnaSkupina krvnaSkupina = (KrvnaSkupina) getCurrentSession().get(KrvnaSkupina.class, id);
		return krvnaSkupina;
	}

	public void deleteEntity(int id) {
		KrvnaSkupina krvnaSkupina = getEntity(id);
		if (krvnaSkupina != null)
			getCurrentSession().delete(krvnaSkupina);
	}

	@SuppressWarnings("unchecked")
	public List<KrvnaSkupina> getEntites() {
		return getCurrentSession().createQuery("from KrvnaSkupina").list();
	}

}
