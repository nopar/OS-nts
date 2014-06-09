package com.sprhib.service;

import java.util.List;

public interface EntityService<T> {
	
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public T getEntity(int id);
	public void deleteEntity(int id);
	public List<T> getEntites();
       public Integer getKonkretny();
//        public List getListJSON();

}
