package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.RestroomDao;

/**
 * 
 * @author olivier
 * Classe correspondant à la table restroom (toilette)
 *
 */

@DatabaseTable(daoClass=RestroomDao.class)
public class Restroom {

	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	private LocatableElement locatable_element;
	
	/**
	 * Constructeur de Restroom 
	 *
	 */
	public Restroom()
	{
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public LocatableElement getLocatable_element()
	{
		return locatable_element;
	}
	
	public void setLocatable_element(LocatableElement element)
	{
		this.locatable_element = element;
	}
	
	@Override
	public String toString() {
		return "Restroom [id=" + id + "]";
	}	
}
