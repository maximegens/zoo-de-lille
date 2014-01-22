package com.platine.zoodelille.beans;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.LocatableElementDao;

/**
 * 
 * @author olivier
 * Classe correspondant à la table locatable_element (utilisé pour Garbage, Restroom et Enclosure)
 *
 */
@DatabaseTable(daoClass=LocatableElementDao.class)
public class LocatableElement 
{

	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField(canBeNull=false)
	private double x_location;
	
	@DatabaseField(canBeNull=false)
	private double y_location;
	
	//eager signifie que la collection doit etre chargée dès l'instanciation. 
	//S'il est false, le chargera se fera dès l'utilisation
	
	@ForeignCollectionField(eager = false)
    private ForeignCollection<Restroom> restrooms;
	
	@ForeignCollectionField(eager = false)
	private ForeignCollection<Garbage> garbages;
	
	@ForeignCollectionField(eager = false)
	private ForeignCollection<Enclosure> enclosures;
	
	public LocatableElement() {}
	
	/**
	 * Constructeur 
	 * @param id 
	 * @param x_location localisation horizontale sur la carte
	 * @param y_location localisation verticale sur la carte
	 */
	public LocatableElement(double x_location, double y_location)
	{
		this.x_location = x_location;
		this.y_location = y_location;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public double getX_location()
	{
		return x_location;
	}
	
	public void setX_location(double x)
	{
		this.x_location = x;
	}
	
	public double getY_location()
	{
		return y_location;
	}
	
	public ForeignCollection<Garbage> getGarbages()
	{
		return garbages;
	}
	
	public void setGarbages(ForeignCollection<Garbage> g)
	{
		garbages = g;
	}
	
	public ForeignCollection<Enclosure> getEnclosures()
	{
		return enclosures;
	}
	
	public void setEnclosures(ForeignCollection<Enclosure> e)
	{
		enclosures = e;
	}
	
	public ForeignCollection<Restroom> getRestrooms()
	{
		return restrooms;
	}
	
	public void setRestrooms(ForeignCollection<Restroom> r)
	{
		restrooms = r;
	}
	
	@Override
	public String toString() {
		return "LocatableElement [id=" + id + ", x_location=" + x_location + ", y_location="
				+ y_location + "]";
	}	
	
	
}
