package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Kraj;

@Repository
public class KrajDAO implements EntityDAO<Kraj> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Kraj kraj) {
		getCurrentSession().save(kraj);
	}

	public void updateEntity(Kraj kraj) {
		Kraj krajToUpdate = getEntity(kraj.getIdKraj());
		krajToUpdate.setKraj(kraj.getKraj());
		krajToUpdate.setIdStat(kraj.getIdStat());
                
		getCurrentSession().update(krajToUpdate);		
	}

	public Kraj getEntity(int id) {
		Kraj kraj = (Kraj) getCurrentSession().get(Kraj.class, id);
		return kraj;
	}

	public void deleteEntity(int id) {
		Kraj kraj = getEntity(id);
		if (kraj != null)
			getCurrentSession().delete(kraj);
	}

	@SuppressWarnings("unchecked")
	public List<Kraj> getEntites() {
		return getCurrentSession().createQuery("from Kraj").list();
	}

}
