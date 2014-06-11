package com.sprhib.dao;

import java.util.List;



public interface EntityVyjazdovyOdberDAO<VyjazdovyOdber> {
	
	void addEntity(VyjazdovyOdber entity);
	void updateEntity(VyjazdovyOdber entity);
	VyjazdovyOdber getEntity(int id);
	void deleteEntity(int id);
	List<VyjazdovyOdber> getEntites();
        List<VyjazdovyOdber> getVyjazdyOdDnes();

}
