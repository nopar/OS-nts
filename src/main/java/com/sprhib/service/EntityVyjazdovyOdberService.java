package com.sprhib.service;

import com.sprhib.model.Pouzivatelia;
import java.util.List;

public interface EntityVyjazdovyOdberService<T> {
	
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public T getEntity(int id);
	public void deleteEntity(int id);
	public List<T> getEntites();
       public Integer getKonkretny();
       public List<T> getVyjazdyOdDnes();
       public List<Pouzivatelia> checkUser(String nick, String pass);
//        public List getListJSON();

}
