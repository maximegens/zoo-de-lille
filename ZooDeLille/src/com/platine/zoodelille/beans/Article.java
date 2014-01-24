package com.platine.zoodelille.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.platine.zoodelille.dao.ArticleDao;

@DatabaseTable(daoClass=ArticleDao.class)
public class Article {
	
	@DatabaseField(generatedId=true)
	public int id;
	
	@DatabaseField(canBeNull=false)
	public String title;
	
	@DatabaseField(canBeNull=false)
	public String content;
	
	@DatabaseField(canBeNull=false)
	public String publication_date;
	
	@DatabaseField(canBeNull=false)
	public String summary;
	
	// Contructor
	
	public Article() {
		super();
	}
	
	public Article(int id, String title, String content, String publication_date,
			String summary) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publication_date = publication_date;
		this.summary = summary;
	}

	// GETTER - SETTER
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	// methods
	
	/**
	 * Return List of article
	 * Ne Focntionne pas manque la List des articles depuis la base de donnée ligne : for(Article article : ???? )
	 
	public List<Article> getCities() {
		ArrayList articles = new ArrayList();
		for(Article article : ??? ) {
			articles.add(article);
		}
		return articles;
	}
	*/
	
	
	

}
