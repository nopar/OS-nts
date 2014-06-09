package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Adresa;

@Repository
public class AdresaDAO implements EntityDAO<Adresa> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Adresa adresa) {
		getCurrentSession().save(adresa);
	}

	public void updateEntity(Adresa adresa) {
		Adresa adresaToUpdate = getEntity(adresa.getIdAdresa());
		adresaToUpdate.setUlica(adresa.getUlica());
		adresaToUpdate.setCisloDomu(adresa.getCisloDomu());
                adresaToUpdate.setIdMesto(adresa.getIdMesto());
                
		getCurrentSession().update(adresaToUpdate);		
	}

	public Adresa getEntity(int id) {
		Adresa adresa = (Adresa) getCurrentSession().get(Adresa.class, id);
		return adresa;
	}

	public void deleteEntity(int id) {
		Adresa adresa = getEntity(id);
		if (adresa != null)
			getCurrentSession().delete(adresa);
	}

	@SuppressWarnings("unchecked")
	public List<Adresa> getEntites() {
		return getCurrentSession().createQuery("from Adresa").list();
	}

}
