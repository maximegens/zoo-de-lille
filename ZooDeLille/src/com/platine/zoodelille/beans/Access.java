
package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.AccessDao;


@DatabaseTable(daoClass=AccessDao.class)
public class Access {
	
	
	@DatabaseField(generatedId=true)
	public int id;
	
	@DatabaseField(canBeNull=false)
	private String transport_mode;
	
	@DatabaseField(canBeNull=false)
	private String explanation;

	public Access() {
		super();
	}

	public Access(int id, String transport_mode, String explanation) {
		super();
		this.id = id;
		this.transport_mode = transport_mode;
		this.explanation = explanation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransport_mode() {
		return transport_mode;
	}

	public void setTransport_mode(String transport_mode) {
		this.transport_mode = transport_mode;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "Access [id=" + id + ", transport_mode=" + transport_mode
				+ ", explanation=" + explanation + "]";
	}

}

