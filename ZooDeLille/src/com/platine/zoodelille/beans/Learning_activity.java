package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.Learning_activityDao;

@DatabaseTable(tableName="cities", daoClass=Learning_activityDao.class)
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
	
	public String picture_location_number1;
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

}
