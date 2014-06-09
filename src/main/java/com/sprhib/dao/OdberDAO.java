package com.sprhib.dao;

import java.util.List;
import com.sprhib.model.Odber;



public interface OdberDAO {
	
	void addEntity(Odber entity);
	void updateEntity(Odber entity);
	Odber getEntity(int id);
	void deleteEntity(int id);
	List<Odber> getEntites();
//      public List getListJSON();

}
