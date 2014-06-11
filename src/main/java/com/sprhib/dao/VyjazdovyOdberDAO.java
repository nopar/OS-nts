package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.VyjazdovyOdber;

@Repository
public class VyjazdovyOdberDAO implements EntityDAO<VyjazdovyOdber> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(VyjazdovyOdber vyjazdovyOdber) {
		getCurrentSession().save(vyjazdovyOdber);
	}

	public void updateEntity(VyjazdovyOdber vyjazdovyOdber) {
		VyjazdovyOdber vyjazdToUpdate = getEntity(vyjazdovyOdber.getIdVyjazdovyOdber());
                
		vyjazdToUpdate.setNazov(vyjazdovyOdber.getNazov());
                vyjazdToUpdate.setDatum(vyjazdovyOdber.getDatum());
                vyjazdToUpdate.setAdresa(vyjazdovyOdber.getAdresa());
                vyjazdToUpdate.setCasZaciatku(vyjazdovyOdber.getCasZaciatku());
                vyjazdToUpdate.setCasKonca(vyjazdovyOdber.getCasKonca());
                vyjazdToUpdate.setBlizsiPopis(vyjazdovyOdber.getBlizsiPopis());
                
                vyjazdToUpdate.setIdKraj(vyjazdovyOdber.getIdKraj());
                vyjazdToUpdate.setIdLekar(vyjazdovyOdber.getIdLekar());
                
		getCurrentSession().update(vyjazdToUpdate);		
	}

	public VyjazdovyOdber getEntity(int id) {
		VyjazdovyOdber vyjazdovyOdber = (VyjazdovyOdber) getCurrentSession().get(VyjazdovyOdber.class, id);
		return vyjazdovyOdber;
	}

	public void deleteEntity(int id) {
		VyjazdovyOdber vyjazdovyOdber = getEntity(id);
		if (vyjazdovyOdber != null)
			getCurrentSession().delete(vyjazdovyOdber);
	}

	@SuppressWarnings("unchecked")
	public List<VyjazdovyOdber> getEntites() {
		return getCurrentSession().createQuery("from VyjazdovyOdber").list();
	}
        
        @SuppressWarnings("unchecked")
	public List<VyjazdovyOdber> getVyjazdyOdDnes() {
		return getCurrentSession().createQuery("from VyjazdovyOdber where datum >= current_date() order by datum asc").list();
	}

}
