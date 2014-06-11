package com.sprhib.dao;

import com.sprhib.model.Nastavenie;
import com.sprhib.model.Pouzivatelia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NastavenieDAO implements EntityNastavenieDAO<Nastavenie> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addEntity(Nastavenie nastavenie) {
        getCurrentSession().save(nastavenie);
    }

    public void updateEntity(Nastavenie nastavenie) {
        Nastavenie nastavenieToUpdate = getEntity(nastavenie.getIdNastavenie());
        nastavenieToUpdate.setMojeOdbery(nastavenie.getMojeOdbery());
        nastavenieToUpdate.setVyjazdoveOdbery(nastavenie.getVyjazdoveOdbery());
        nastavenieToUpdate.setUrgentnePripady(nastavenie.getUrgentnePripady());
        nastavenieToUpdate.setKraj(nastavenie.getKraj());

        getCurrentSession().update(nastavenieToUpdate);
    }

    public Nastavenie getEntity(int id) {
        Nastavenie nastavenie = (Nastavenie) getCurrentSession().get(Nastavenie.class, id);
        return nastavenie;
    }

    public void deleteEntity(int id) {
        Nastavenie nastavenie = getEntity(id);
        if (nastavenie != null) {
            getCurrentSession().delete(nastavenie);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Nastavenie> getEntites() {
        return getCurrentSession().createQuery("from Nastavenie").list();
    }

    
    @SuppressWarnings("unchecked")
    public List<Pouzivatelia> getPouzivatelaList(Integer nickID) {
        Session session = getCurrentSession();

        Query query = session.createQuery("from Pouzivatelia where id_user = :xx ");
        query.setParameter("xx", nickID);
        List list = query.list();
        
        return list;
    }
    
    
    @SuppressWarnings("unchecked")
    public List<Nastavenie> getMojeSetings(Integer fkNastavenieID) {
        Session session = getCurrentSession();

        Query query = session.createQuery("from Nastavenie where id_nastavenie = :xx ");
        query.setParameter("xx", fkNastavenieID);
        List list = query.list();
        
         
         


        return list;
    }

    

}
