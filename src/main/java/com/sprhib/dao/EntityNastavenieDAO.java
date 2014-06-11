package com.sprhib.dao;

import com.sprhib.model.Nastavenie;
import com.sprhib.model.Odber;
import com.sprhib.model.Pouzivatelia;
import java.util.List;



public interface EntityNastavenieDAO<T> {
	
	void addEntity(T entity);
	void updateEntity(T entity);
	T getEntity(int id);
	void deleteEntity(int id);
	List<T> getEntites();
        List<Pouzivatelia> getPouzivatelaList(Integer nickID);
        List<T> getMojeSetings(Integer nickID);
        List<T> getEntitaList(Integer id);
}
