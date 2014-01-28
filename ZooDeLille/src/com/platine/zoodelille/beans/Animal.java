package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.AnimalDao;

/**
 * Cette classe références les caractériques d'un animal.
 *
 */
@DatabaseTable(daoClass = AnimalDao.class)
public class Animal {

	@DatabaseField(generatedId=true)
	private int id;
	@DatabaseField(canBeNull=false)
	private String name;
	@DatabaseField(canBeNull=false)
	private int category_id;
	@DatabaseField(canBeNull=false)
	private int country_id;
	@DatabaseField
	private String description;
	@DatabaseField
	private String environnement;
	@DatabaseField
	private String longevity;
	@DatabaseField
	private int protected_animal;
	@DatabaseField
	private float weight;
	@DatabaseField
	private int gestation;
	@DatabaseField
	private String picture_location;
	
	public Animal(){
		
	}
	
	/**
	 * Constructeur.
	 * @param name Le nom de l'animal.
	 * @param category_id L'id de la catégorie de l'animal ( Mammifére, Reptile etc ).
	 * @param country_id L'id du pays de l'animal.
	 * @param description La description de l'animal.
	 * @param environnement L'environnement de l'animal.
	 * @param longevity La durée de vie moyenne de l'animal.
	 * @param protected_animal Permet de savoir si l'animal est une espéce protégée.
	 * @param weight Le poids de l'animal.
	 * @param gestation La durée de gestation de l'animal.
	 * @param picture_location Le chemin de la photo de l'animal.
	 */
	
	public Animal(String name, int category_id,
			int country_id, String description, String environnement,
			String longevity, int protected_animal, float weight,
			int gestation, String picture_location) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.country_id = country_id;
		this.description = description;
		this.environnement = environnement;
		this.longevity = longevity;
		this.protected_animal = protected_animal;
		this.weight = weight;
		this.gestation = gestation;
		this.picture_location = picture_location;
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
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnvironnement() {
		return environnement;
	}
	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}
	public String getLongevity() {
		return longevity;
	}
	public void setLongevity(String longevity) {
		this.longevity = longevity;
	}
	public int getProtected_animal() {
		return protected_animal;
	}
	public void setProtected_animal(int protected_animal) {
		this.protected_animal = protected_animal;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getGestation() {
		return gestation;
	}
	public void setGestation(int gestation) {
		this.gestation = gestation;
	}
	public String getPicture_location() {
		return picture_location;
	}
	public void setPicture_location(String picture_location) {
		this.picture_location = picture_location;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", category_id="
				+ category_id + ", country_id=" + country_id + ", description="
				+ description + ", environnement=" + environnement
				+ ", longevity=" + longevity + ", protected_animal="
				+ protected_animal + ", weight=" + weight + ", gestation="
				+ gestation + ", picture_location=" + picture_location + "]";
	}	
	
}
