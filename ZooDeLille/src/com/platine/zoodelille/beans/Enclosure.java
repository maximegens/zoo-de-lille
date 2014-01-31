package com.platine.zoodelille.beans;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.EnclosureDao;

/**
 * 
 * @author olivier
 * Classe correspondant à la table enclosure (enclos)
 *
 */

@DatabaseTable(daoClass=EnclosureDao.class)
public class Enclosure implements NamableElement {
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField(canBeNull = true)
	private String name;
	
	@DatabaseField(canBeNull = false, foreign = true, foreignAutoCreate = true,foreignAutoRefresh = true)
	private LocatableElement locatable_element;
	
	@ForeignCollectionField(eager = false)
    private ForeignCollection<Animal> animals;
	
	/**
	 * Constructeur d'enclos
	 */
	public Enclosure()
	{	
	}
	
	public Enclosure(String name, LocatableElement loc_elm)
	{	
		this.name = name;
		this.locatable_element = loc_elm;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public LocatableElement getLocatable_element()
	{
		return locatable_element;
	}
	
	public void setLocatable_element(LocatableElement element)
	{
		this.locatable_element = element;
	}
	
	public ForeignCollection<Animal> getAnimals()
	{
		return animals;
	}
	
	public void setAnimals(ForeignCollection<Animal> animals)
	{
		this.animals = animals;
	}
	
	@Override
	public String toString() {
		return "Enclosure [id=" + id + ",animals=" + animals + ",locatable_element=" + locatable_element +"]";
	}	
}
