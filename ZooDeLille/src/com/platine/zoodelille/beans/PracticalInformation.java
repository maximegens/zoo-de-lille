package com.platine.zoodelille.beans;

import java.util.Date;

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
	public Date summer_week_opening_time;
	@DatabaseField
	public Date summer_week_closing_time;
	
	//Weekend
	@DatabaseField
	public Date summer_weekend_opening_time;
	@DatabaseField
	public Date summer_weekend_closing_time;
	
	// Winter
	
	// Week
	@DatabaseField
	public Date winter_week_opening_time;
	@DatabaseField
	public Date winter_week_closing_time;
	
	// Weekend
	@DatabaseField
	public Date winter_weekend_opening_time;
	@DatabaseField
	public Date winter_weekend_closing_time;
	
	//Annual
	@DatabaseField
	public Date annual_closing;
	@DatabaseField
	public Date annual_opening;
	
	
	public PracticalInformation() {
		super();
	}


	public PracticalInformation(Date summer_week_opening_time,
			Date summer_week_closing_time, Date summer_weekend_opening_time,
			Date summer_weekend_closing_time, Date winter_week_opening_time,
			Date winter_week_closing_time, Date winter_weekend_opening_time,
			Date winter_weekend_closing_time, Date annual_closing,
			Date annual_opening) {
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getSummer_week_opening_time() {
		return summer_week_opening_time;
	}


	public void setSummer_week_opening_time(Date summer_week_opening_time) {
		this.summer_week_opening_time = summer_week_opening_time;
	}


	public Date getSummer_week_closing_time() {
		return summer_week_closing_time;
	}


	public void setSummer_week_closing_time(Date summer_week_closing_time) {
		this.summer_week_closing_time = summer_week_closing_time;
	}


	public Date getSummer_weekend_opening_time() {
		return summer_weekend_opening_time;
	}


	public void setSummer_weekend_opening_time(Date summer_weekend_opening_time) {
		this.summer_weekend_opening_time = summer_weekend_opening_time;
	}


	public Date getSummer_weekend_closing_time() {
		return summer_weekend_closing_time;
	}


	public void setSummer_weekend_closing_time(Date summer_weekend_closing_time) {
		this.summer_weekend_closing_time = summer_weekend_closing_time;
	}


	public Date getWinter_week_opening_time() {
		return winter_week_opening_time;
	}


	public void setWinter_week_opening_time(Date winter_week_opening_time) {
		this.winter_week_opening_time = winter_week_opening_time;
	}


	public Date getWinter_week_closing_time() {
		return winter_week_closing_time;
	}


	public void setWinter_week_closing_time(Date winter_week_closing_time) {
		this.winter_week_closing_time = winter_week_closing_time;
	}


	public Date getWinter_weekend_opening_time() {
		return winter_weekend_opening_time;
	}


	public void setWinter_weekend_opening_time(Date winter_weekend_opening_time) {
		this.winter_weekend_opening_time = winter_weekend_opening_time;
	}


	public Date getWinter_weekend_closing_time() {
		return winter_weekend_closing_time;
	}


	public void setWinter_weekend_closing_time(Date winter_weekend_closing_time) {
		this.winter_weekend_closing_time = winter_weekend_closing_time;
	}


	public Date getAnnual_closing() {
		return annual_closing;
	}


	public void setAnnual_closing(Date annual_closing) {
		this.annual_closing = annual_closing;
	}


	public Date getAnnual_opening() {
		return annual_opening;
	}


	public void setAnnual_opening(Date annual_opening) {
		this.annual_opening = annual_opening;
	}



}
