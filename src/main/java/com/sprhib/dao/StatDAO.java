package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Stat;

@Repository
public class StatDAO implements EntityDAO<Stat> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Stat stat) {
		getCurrentSession().save(stat);
	}

	public void updateEntity(Stat stat) {
		Stat statToUpdate = getEntity(stat.getIdStat());
		statToUpdate.setStat(stat.getStat());
		statToUpdate.setSkratka(stat.getSkratka());
		getCurrentSession().update(statToUpdate);		
	}

	public Stat getEntity(int id) {
		Stat stat = (Stat) getCurrentSession().get(Stat.class, id);
		return stat;
	}

	public void deleteEntity(int id) {
		Stat stat = getEntity(id);
		if (stat != null)
			getCurrentSession().delete(stat);
	}

	@SuppressWarnings("unchecked")
	public List<Stat> getEntites() {
		return getCurrentSession().createQuery("from Stat").list();
	}
        
//        public List<Stat> getListJSON() {
//        
//            List songList = getCurrentSession().createQuery("from Stat").list();
//            return songList;
//        
//        }

}
