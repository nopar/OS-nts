package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Mesto;

@Repository
public class MestoDAO implements EntityDAO<Mesto> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Mesto stat) {
		getCurrentSession().save(stat);
	}

	public void updateEntity(Mesto stat) {
		Mesto mestoToUpdate = getEntity(stat.getIdMesto());
		mestoToUpdate.setMesto(stat.getMesto());
		mestoToUpdate.setPsc(stat.getPsc());
                mestoToUpdate.setIdKraj(stat.getIdKraj());
                
		getCurrentSession().update(mestoToUpdate);		
	}

	public Mesto getEntity(int id) {
		Mesto stat = (Mesto) getCurrentSession().get(Mesto.class, id);
		return stat;
	}

	public void deleteEntity(int id) {
		Mesto stat = getEntity(id);
		if (stat != null)
			getCurrentSession().delete(stat);
	}

	@SuppressWarnings("unchecked")
	public List<Mesto> getEntites() {
		return getCurrentSession().createQuery("from Mesto").list();
	}

}
