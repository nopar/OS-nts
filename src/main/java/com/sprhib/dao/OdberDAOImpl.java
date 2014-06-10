package com.sprhib.dao;

import com.sprhib.model.Odber;
import com.sprhib.model.Pouzivatelia;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OdberDAOImpl implements OdberDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addEntity(Odber odber) {
        getCurrentSession().save(odber);
    }

    public void updateEntity(Odber odber) {
        Odber odberToUpdate = getEntity(odber.getIdOdber());

        odberToUpdate.setDatum(odber.getDatum());
        odberToUpdate.setObjem(odber.getObjem());
        odberToUpdate.setPoznamka(odber.getPoznamka());
        odberToUpdate.setIdDarca(odber.getIdDarca());
        odberToUpdate.setIdLekar(odber.getIdLekar());

        getCurrentSession().update(odberToUpdate);
    }

    public Odber getEntity(int id) {
        Odber odber = (Odber) getCurrentSession().get(Odber.class, id);
        return odber;
    }

    public void deleteEntity(int id) {
        Odber odber = getEntity(id);
        if (odber != null) {
            getCurrentSession().delete(odber);
        }
    }

    
    @SuppressWarnings("unchecked")
    public Integer getUserIDfromNick(String logNick) {
        Session session = getCurrentSession();
        
        //mkyong
        Query query = session.createQuery("from Pouzivatelia where nick = :xx ");
        query.setParameter("xx", logNick);
        List list = query.list();
//           System.out.println("xx hladam darcu :" + list);
//           System.out.println("xx jeho ID: " + list.get(0));
        Pouzivatelia pouzivatel = (Pouzivatelia) list.get(0);
//        System.out.println("toto idem vratit: " + pouzivatel.getIdUser());
        
        return pouzivatel.getIdUser();
    }
    
    

    @SuppressWarnings("unchecked")
    public Integer getOdbery(String logNick) {
        
        Integer UseroveID = getUserIDfromNick(logNick);       

        long cisloFromQuery = (long) getCurrentSession().createQuery("select count(*) from Odber where id_darca = '" + UseroveID + "'").uniqueResult();
        Integer pocet = (int) (long) cisloFromQuery;

        return pocet;
        //select count(*) from ODBER where id_darca = '2';

    }
    
    @SuppressWarnings("unchecked")
    public List<Odber> getEntites() {
        return getCurrentSession().createQuery("from Odber").list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Odber> getOdberHistory(Integer nickID) {
        
        Session session = getCurrentSession();
        
        Query query = session.createQuery("from Odber where id_darca = :xx ");
        query.setParameter("xx", nickID);
        List list = query.list();
 
        String sqlo = "from Odber where id_darca = '" + nickID + "'";
//        return getCurrentSession().createQuery(sqlo).list();
        return list;
    }

}
