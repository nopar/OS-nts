package com.sprhib.service;

import java.util.List;

public interface EntityOdberService<T> {
	
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public T getEntity(int id);
	public void deleteEntity(int id);
	public List<T> getEntites();
       public Integer getKonkretny(String hladanyNick);
       public Integer getUserIDfromNick(String logNick);
       public List<T> getMojeOdberyHistory(int nickID);
       public List<T> getLastOdber(Integer nickID);
//        public List getListJSON();

}
