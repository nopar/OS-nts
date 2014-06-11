package com.sprhib.service;

import com.sprhib.model.Nastavenie;
import com.sprhib.model.Pouzivatelia;
import java.util.List;

public interface EntityNastavenieService<T> {
	
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public T getEntity(int id);
	public void deleteEntity(int id);
	public List<T> getEntites();
       public Integer getKonkretny();
        public List<Pouzivatelia> getPouzivatelaList(Integer nickID);
        public List<T> getMojeSetings(Integer nickID);


}
