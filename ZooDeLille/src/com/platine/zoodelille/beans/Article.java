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
	
	@DatabaseField(canBeNull=true)
	public String lien_image;
	
	// Contructor
	
	public Article() {
		super();
	}
	
	public Article(String title, String content, String publication_date,
			String summary, String lien_image) {
		super();
		this.title = title;
		this.content = content;
		this.publication_date = publication_date;
		this.summary = summary;
		this.lien_image = lien_image;
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

	public String getLien_image() {
		return lien_image;
	}

	public void setLien_image(String lien_image) {
		this.lien_image = lien_image;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", publication_date=" + publication_date
				+ ", summary=" + summary + ", lien_image=" + lien_image + "]";
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
