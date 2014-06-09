package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Nts;

@Repository
public class NtsDAO implements EntityDAO<Nts> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Nts nts) {
		getCurrentSession().save(nts);
	}

	public void updateEntity(Nts nts) {
		Nts ntsToUpdate = getEntity(nts.getIdNts());
                
		ntsToUpdate.setMesto(nts.getMesto());
                ntsToUpdate.setAdresa(nts.getAdresa());
                ntsToUpdate.setEmail(nts.getEmail());
                ntsToUpdate.setTelKontakt(nts.getTelKontakt());
                ntsToUpdate.setAktivna(nts.getAktivna());
                ntsToUpdate.setIdKraj(nts.getIdKraj());
                
		getCurrentSession().update(ntsToUpdate);		
	}

	public Nts getEntity(int id) {
		Nts nts = (Nts) getCurrentSession().get(Nts.class, id);
		return nts;
	}

	public void deleteEntity(int id) {
		Nts nts = getEntity(id);
		if (nts != null)
			getCurrentSession().delete(nts);
	}

	@SuppressWarnings("unchecked")
	public List<Nts> getEntites() {
		return getCurrentSession().createQuery("from Nts").list();
	}

}
