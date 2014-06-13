package com.sprhib.dao;

import com.sprhib.model.Pouzivatelia;
import com.sprhib.model.VyjazdovyOdber;
import com.sprhib.model.ZaznamDarcu;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VyjazdovyOdberDAO implements EntityVyjazdovyOdberDAO<VyjazdovyOdber> {
	
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
            // + "datum >= (current_date()-30) order by datum asc"
            //(day(current_date()) - day(datum)) < 10
		return getCurrentSession().createQuery("from VyjazdovyOdber where datum >= (current_date()-30) order by datum asc").list();
	}
        
        @SuppressWarnings("unchecked")
	public List<VyjazdovyOdber> getVyjazdyOdDnes() {
            Session session = getCurrentSession();
            
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR_OF_DAY, 3);
            
            Query q = session.createQuery("from VyjazdovyOdber where datum > :date order by datum asc");
            q.setCalendarDate("date", cal);
            q.list();

            return q.list();
		//return getCurrentSession().createQuery("from VyjazdovyOdber where datum >= current_date() order by datum asc").list();
	}
        
        @SuppressWarnings("unchecked")
        public List<Pouzivatelia> checkUser(String nick, String pass) {
         Session session = getCurrentSession();
        
        Query query = session.createQuery("from Pouzivatelia where nick = :nick and password = :pass");
        query.setParameter("nick", nick);
        query.setParameter("pass", pass);
        List list = query.list();
 
        return list;
    }

  

}
