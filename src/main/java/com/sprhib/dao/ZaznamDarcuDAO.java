package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.ZaznamDarcu;

@Repository
public class ZaznamDarcuDAO implements EntityDAO<ZaznamDarcu> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(ZaznamDarcu zaznamDarcu) {
		getCurrentSession().save(zaznamDarcu);
	}

	public void updateEntity(ZaznamDarcu zaznamDarcu) {
		ZaznamDarcu zaznamDarcuToUpdate = getEntity(zaznamDarcu.getIdZaznamDarcu());
                
		zaznamDarcuToUpdate.setDatum(zaznamDarcu.getDatum());
                zaznamDarcuToUpdate.setPoznamka(zaznamDarcu.getPoznamka());
                zaznamDarcuToUpdate.setIdDarca(zaznamDarcu.getIdDarca());
                zaznamDarcuToUpdate.setIdLekar(zaznamDarcu.getIdLekar());
                
		getCurrentSession().update(zaznamDarcuToUpdate);	
                
	}

	public ZaznamDarcu getEntity(int id) {
		ZaznamDarcu zaznamDarcu = (ZaznamDarcu) getCurrentSession().get(ZaznamDarcu.class, id);
		return zaznamDarcu;
	}

	public void deleteEntity(int id) {
		ZaznamDarcu zaznamDarcu = getEntity(id);
		if (zaznamDarcu != null)
			getCurrentSession().delete(zaznamDarcu);
	}

	@SuppressWarnings("unchecked")
	public List<ZaznamDarcu> getEntites() {
		return getCurrentSession().createQuery("from ZaznamDarcu").list();
	}

}
