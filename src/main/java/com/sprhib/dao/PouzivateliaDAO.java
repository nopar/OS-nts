package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Pouzivatelia;
import org.hibernate.Query;

@Repository
public class PouzivateliaDAO implements EntityDAO<Pouzivatelia> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Pouzivatelia pouzivatelia) {
		getCurrentSession().save(pouzivatelia);
	}

	public void updateEntity(Pouzivatelia pouzivatelia) {
		Pouzivatelia pouzivatelToUpdate = getEntity(pouzivatelia.getIdUser());
                
		pouzivatelToUpdate.setEmail(pouzivatelia.getEmail());
                pouzivatelToUpdate.setNick(pouzivatelia.getNick());
                pouzivatelToUpdate.setPassword(pouzivatelia.getPassword());
                pouzivatelToUpdate.setMeno(pouzivatelia.getMeno());
                pouzivatelToUpdate.setPriezvisko(pouzivatelia.getPriezvisko());
                pouzivatelToUpdate.setDatumNarodenia(pouzivatelia.getDatumNarodenia());
                pouzivatelToUpdate.setTelKontakt(pouzivatelia.getTelKontakt());
                pouzivatelToUpdate.setPohlavie(pouzivatelia.getPohlavie());
                pouzivatelToUpdate.setResetPasswd(pouzivatelia.getResetPasswd());
                pouzivatelToUpdate.setEnabled(pouzivatelia.getEnabled());
                
                pouzivatelToUpdate.setIdNastavenie(pouzivatelia.getIdNastavenie());
                pouzivatelToUpdate.setIdKrvnaSkupina(pouzivatelia.getIdKrvnaSkupina());
                pouzivatelToUpdate.setIdAdresa(pouzivatelia.getIdAdresa());
                
		getCurrentSession().update(pouzivatelToUpdate);		
	}

	public Pouzivatelia getEntity(int id) {
		Pouzivatelia pouzivatelia = (Pouzivatelia) getCurrentSession().get(Pouzivatelia.class, id);
		return pouzivatelia;
	}

	public void deleteEntity(int id) {
		Pouzivatelia pouzivatelia = getEntity(id);
		if (pouzivatelia != null)
			getCurrentSession().delete(pouzivatelia);
	}

	@SuppressWarnings("unchecked")
	public List<Pouzivatelia> getEntites() {
		return getCurrentSession().createQuery("from Pouzivatelia").list();
	}
    

}
