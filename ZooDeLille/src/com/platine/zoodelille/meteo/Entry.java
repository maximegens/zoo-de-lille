package com.platine.zoodelille.meteo;

/**
 * Classe permettant de sauvegarder les données météo reçu depuis le site météorologique de Yahoo. 
 *
 */
public class Entry {
	
	private long id;
	private String link;
	private String description;
	
	private String temperature;
	private String code_image;

	public Entry() {
		super();
	}

	public Entry(long id, String link, String description) {
		super();
		this.id = id;
		this.link = link;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getCodeImage() {
		return code_image;
	}

	public void setCodeImage(String code_image) {
		this.code_image = code_image;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", link=" + link + ", description="
				+ description + ", temperature=" + temperature
				+ ", code_image=" + code_image + "]";
	}
}