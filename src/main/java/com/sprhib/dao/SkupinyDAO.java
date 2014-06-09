package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Skupiny;

@Repository
public class SkupinyDAO implements EntityDAO<Skupiny> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Skupiny skupina) {
		getCurrentSession().save(skupina);
	}

	public void updateEntity(Skupiny skupina) {
		Skupiny skupinaToUpdate = getEntity(skupina.getIdGroup());
		skupinaToUpdate.setAutorita(skupina.getAutorita());
		skupinaToUpdate.setSpecialne(skupina.getSpecialne());
		getCurrentSession().update(skupinaToUpdate);		
	}

	public Skupiny getEntity(int id) {
		Skupiny skupina = (Skupiny) getCurrentSession().get(Skupiny.class, id);
		return skupina;
	}

	public void deleteEntity(int id) {
		Skupiny skupina = getEntity(id);
		if (skupina != null)
			getCurrentSession().delete(skupina);
	}

	@SuppressWarnings("unchecked")
	public List<Skupiny> getEntites() {
		return getCurrentSession().createQuery("from Skupiny").list();
	}

}
