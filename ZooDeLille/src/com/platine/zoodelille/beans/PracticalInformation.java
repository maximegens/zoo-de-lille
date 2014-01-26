package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.PracticalInformationDao;

@DatabaseTable(daoClass=PracticalInformationDao.class)
public class PracticalInformation {
	
	
	@DatabaseField(generatedId=true)
	public int id;
	
	//Summer
	
	//Week
	@DatabaseField
	public String summer_week_opening_time;
	@DatabaseField
	public String summer_week_closing_time;
	
	//Weekend
	@DatabaseField
	public String summer_weekend_opening_time;
	@DatabaseField
	public String summer_weekend_closing_time;
	
	// Winter
	
	// Week
	@DatabaseField
	public String winter_week_opening_time;
	@DatabaseField
	public String winter_week_closing_time;
	
	// Weekend
	@DatabaseField
	public String winter_weekend_opening_time;
	@DatabaseField
	public String winter_weekend_closing_time;
	
	//Annual
	@DatabaseField
	public String annual_closing;
	@DatabaseField
	public String annual_opening;
	
	
	public PracticalInformation() {
		super();
	}


	public PracticalInformation(String summer_week_opening_time,
			String summer_week_closing_time,
			String summer_weekend_opening_time,
			String summer_weekend_closing_time,
			String winter_week_opening_time, String winter_week_closing_time,
			String winter_weekend_opening_time,
			String winter_weekend_closing_time, String annual_closing,
			String annual_opening) {
		super();
		this.summer_week_opening_time = summer_week_opening_time;
		this.summer_week_closing_time = summer_week_closing_time;
		this.summer_weekend_opening_time = summer_weekend_opening_time;
		this.summer_weekend_closing_time = summer_weekend_closing_time;
		this.winter_week_opening_time = winter_week_opening_time;
		this.winter_week_closing_time = winter_week_closing_time;
		this.winter_weekend_opening_time = winter_weekend_opening_time;
		this.winter_weekend_closing_time = winter_weekend_closing_time;
		this.annual_closing = annual_closing;
		this.annual_opening = annual_opening;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSummer_week_opening_time() {
		return summer_week_opening_time;
	}


	public void setSummer_week_opening_time(String summer_week_opening_time) {
		this.summer_week_opening_time = summer_week_opening_time;
	}


	public String getSummer_week_closing_time() {
		return summer_week_closing_time;
	}


	public void setSummer_week_closing_time(String summer_week_closing_time) {
		this.summer_week_closing_time = summer_week_closing_time;
	}


	public String getSummer_weekend_opening_time() {
		return summer_weekend_opening_time;
	}


	public void setSummer_weekend_opening_time(String summer_weekend_opening_time) {
		this.summer_weekend_opening_time = summer_weekend_opening_time;
	}


	public String getSummer_weekend_closing_time() {
		return summer_weekend_closing_time;
	}


	public void setSummer_weekend_closing_time(String summer_weekend_closing_time) {
		this.summer_weekend_closing_time = summer_weekend_closing_time;
	}


	public String getWinter_week_opening_time() {
		return winter_week_opening_time;
	}


	public void setWinter_week_opening_time(String winter_week_opening_time) {
		this.winter_week_opening_time = winter_week_opening_time;
	}


	public String getWinter_week_closing_time() {
		return winter_week_closing_time;
	}


	public void setWinter_week_closing_time(String winter_week_closing_time) {
		this.winter_week_closing_time = winter_week_closing_time;
	}


	public String getWinter_weekend_opening_time() {
		return winter_weekend_opening_time;
	}


	public void setWinter_weekend_opening_time(String winter_weekend_opening_time) {
		this.winter_weekend_opening_time = winter_weekend_opening_time;
	}


	public String getWinter_weekend_closing_time() {
		return winter_weekend_closing_time;
	}


	public void setWinter_weekend_closing_time(String winter_weekend_closing_time) {
		this.winter_weekend_closing_time = winter_weekend_closing_time;
	}


	public String getAnnual_closing() {
		return annual_closing;
	}


	public void setAnnual_closing(String annual_closing) {
		this.annual_closing = annual_closing;
	}


	public String getAnnual_opening() {
		return annual_opening;
	}


	public void setAnnual_opening(String annual_opening) {
		this.annual_opening = annual_opening;
	}


	@Override
	public String toString() {
		return "PracticalInformation [id=" + id + ", summer_week_opening_time="
				+ summer_week_opening_time + ", summer_week_closing_time="
				+ summer_week_closing_time + ", summer_weekend_opening_time="
				+ summer_weekend_opening_time
				+ ", summer_weekend_closing_time="
				+ summer_weekend_closing_time + ", winter_week_opening_time="
				+ winter_week_opening_time + ", winter_week_closing_time="
				+ winter_week_closing_time + ", winter_weekend_opening_time="
				+ winter_weekend_opening_time
				+ ", winter_weekend_closing_time="
				+ winter_weekend_closing_time + ", annual_closing="
				+ annual_closing + ", annual_opening=" + annual_opening + "]";
	}


	


}
