package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.LearningEvent;

public class LearningEventDao extends BaseDaoImpl<LearningEvent,Integer> {
	
	public LearningEventDao(ConnectionSource connectionSource)
			throws java.sql.SQLException {
			super(connectionSource, LearningEvent.class);
		}
 
	/**
	 * Sauvegarde un learningEvent dans la base de données.
	 * @param a L'learningEvent à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(LearningEvent a){
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un learningEvent.
	 * @param a L'learningEvent à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(LearningEvent a){
		return update(a);
	}
	
	/**
	 * Liste de tous les learningEvent de la base de données.
	 * @return Une liste des learningEvent de la base de données.
	 */
	public List<LearningEvent> findAll() {
		List<LearningEvent> cities = null;
		try {
			cities = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}
 
	/**
	 * Récupérer un learningEvent en particulier en fonction de son ID.
	 * @param id L'id de l'learningEvent.
	 * @return L'learningEvent correspondant à l'ID.
	 */
	public LearningEvent findById(int id) {
		LearningEvent city = null;
		try {
			city = (LearningEvent) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	/**
	 * Supprime un learningEvent.
	 * @param a L'learningEvent à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(LearningEvent a){
		return delete(a);
	}
	
	/**
	 * Le nombre d'learningEvent contenu dans la base de données.
	 * @return Le nombre d'learningEvent.
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