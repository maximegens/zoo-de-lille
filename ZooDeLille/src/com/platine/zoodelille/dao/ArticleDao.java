package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Article;

public class ArticleDao extends BaseDaoImpl<Article,Integer>{
	
	public ArticleDao(ConnectionSource connectionSource)
			throws java.sql.SQLException {
			super(connectionSource, Article.class);
		}
 
	/**
	 * Sauvegarde un article dans la base de données.
	 * @param a L'article à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(Article a){
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un article.
	 * @param a L'article à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(Article a){
		return update(a);
	}
	
	/**
	 * Liste de tous les article de la base de données.
	 * @return Une liste des articles de la base de données.
	 */
	public List<Article> findAll() {
		List<Article> cities = null;
		try {
			cities = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}
 
	/**
	 * Récupérer un article en particulier en fonction de son ID.
	 * @param id L'id de l'article.
	 * @return L'article correspondant à l'ID.
	 */
	public Article findById(int id) {
		Article city = null;
		try {
			city = (Article) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	/**
	 * Supprime un article.
	 * @param a L'article à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(Article a){
		return delete(a);
	}
	
	/**
	 * Le nombre d'article contenu dans la base de données.
	 * @return Le nombre d'animaux.
	 */
	public long count(){
		try {
			return countOf();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}