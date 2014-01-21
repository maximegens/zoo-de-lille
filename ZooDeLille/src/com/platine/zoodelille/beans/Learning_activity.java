package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.Learning_activityDao;

@DatabaseTable(daoClass=Learning_activityDao.class)
public class Learning_activity {
	
	@DatabaseField(generatedId=true)
	public int id;
	
	@DatabaseField(canBeNull=false)
	public String title;
	
	@DatabaseField(canBeNull=false)
	public String description;
	
	@DatabaseField(canBeNull=false)
	public String date;
	
	@DatabaseField(canBeNull=false)
	public String time;
	
	@DatabaseField
	public String picture_location_number1;
	@DatabaseField
	public String picture_location_number2;



	public Learning_activity() {
		super();
	}
	
	public Learning_activity(int id, String title, String description,
			String date, String time) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.time = time;
	}

	public Learning_activity(int id, String title, String description,
			String date, String time, String picture_location_number1,
			String picture_location_number2) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.time = time;
		this.picture_location_number1 = picture_location_number1;
		this.picture_location_number2 = picture_location_number2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPicture_location_number1() {
		return picture_location_number1;
	}

	public void setPicture_location_number1(String picture_location_number1) {
		this.picture_location_number1 = picture_location_number1;
	}

	public String getPicture_location_number2() {
		return picture_location_number2;
	}

	public void setPicture_location_number2(String picture_location_number2) {
		this.picture_location_number2 = picture_location_number2;
	}

	@Override
	public String toString() {
		return "Learning_activity [id=" + id + ", title=" + title
				+ ", description=" + description + ", date=" + date + ", time="
				+ time + ", picture_location_number1="
				+ picture_location_number1 + ", picture_location_number2="
				+ picture_location_number2 + "]";
	}
	
	

}
