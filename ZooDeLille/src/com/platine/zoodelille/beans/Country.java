package com.platine.zoodelille.beans;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.CountryDao;

@DatabaseTable(daoClass=CountryDao.class)
public class Country implements NamableElement{
	
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField(canBeNull=false)
	private String name;

	@ForeignCollectionField(eager = false)
    private ForeignCollection<Animal> animals;
	
	public Country() {
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAnimals(ForeignCollection<Animal> animals)
	{
		this.animals = animals;
	}
	
	public ForeignCollection<Animal> getAnimals()
	{
		return animals;
	}
	
	public String toString()
	{
		return "[id=" + id + ",name=" + name + "]";
	}

}
