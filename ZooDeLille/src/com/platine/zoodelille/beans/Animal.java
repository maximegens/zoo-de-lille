package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.AnimalDao;

/**
 * Cette classe références les caractériques d'un animal.
 *
 */
@DatabaseTable(daoClass = AnimalDao.class)
public class Animal implements NamableElement {

	@DatabaseField(generatedId=true)
	private int id;
	@DatabaseField(canBeNull=false)
	private String name;
	@DatabaseField(canBeNull=false, foreign=true, foreignAutoRefresh = true)
	private AnimalCategory category;
	@DatabaseField(canBeNull=false, foreign=true, foreignAutoRefresh = true)
	private Country country;
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
	
	@DatabaseField(canBeNull = true, foreign = true, foreignAutoRefresh = true)
	private Enclosure enclosure;
	
	public Animal(){
		
	}
	
	/**
	 * Constructeur.
	 * @param name Le nom de l'animal.
	 * @param category La catégorie de l'animal ( Mammifére, Reptile etc ).
	 * @param country Le pays de l'animal.
	 * @param description La description de l'animal.
	 * @param environnement L'environnement de l'animal.
	 * @param longevity La durée de vie moyenne de l'animal.
	 * @param protected_animal Permet de savoir si l'animal est une espéce protégée.
	 * @param weight Le poids de l'animal.
	 * @param gestation La durée de gestation de l'animal.
	 * @param picture_location Le chemin de la photo de l'animal.
	 * @param enclosure L'enclos dans lequel l'animal se trouve.
	 */
	public Animal(String name, AnimalCategory category, Country country,
			String description, String environnement, String longevity,
			int protected_animal, float weight, int gestation,
			String picture_locationn, Enclosure enclosure) {
		super();
		this.name = name;
		this.category = category;
		this.country = country;
		this.description = description;
		this.environnement = environnement;
		this.longevity = longevity;
		this.protected_animal = protected_animal;
		this.weight = weight;
		this.gestation = gestation;
		this.picture_location = picture_location;
		this.enclosure = enclosure;
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
	public AnimalCategory getCategory() {
		return category;
	}
	public void setCategory(AnimalCategory category) {
		this.category = category;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
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
	public void setEnclosure(Enclosure enclosure)
	{
		this.enclosure = enclosure;
	}
	public Enclosure getEnclosure()
	{
		return enclosure;
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", category="
				+ category + ", country=" + country + ", description="
				+ description + ", environnement=" + environnement
				+ ", longevity=" + longevity + ", protected_animal="
				+ protected_animal + ", weight=" + weight + ", gestation="
				+ gestation + ", picture_location=" + picture_location + ", enclosure=" + enclosure + "]";
	}	
}