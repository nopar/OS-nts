package com.sprhib.dao;

import java.util.List;
import com.sprhib.model.Odber;



public interface EntityPouzivateliaDAO<T> {
	
	void addEntity(T entity);
	void updateEntity(T entity);
	T getEntity(int id);
	void deleteEntity(int id);
	List<T> getEntites();
        List<T> checkUser(String nick, String pass);

}
