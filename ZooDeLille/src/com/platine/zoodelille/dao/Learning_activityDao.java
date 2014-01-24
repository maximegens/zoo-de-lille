package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Learning_activity;

public class Learning_activityDao extends BaseDaoImpl<Learning_activity,Integer> {
	
	public Learning_activityDao(ConnectionSource connectionSource)
			throws java.sql.SQLException {
			super(connectionSource, Learning_activity.class);
		}
 
	/**
	 * Sauvegarde un access dans la base de données.
	 * @param a L'access à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(Learning_activity a){
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un access.
	 * @param a L'access à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(Learning_activity a){
		return update(a);
	}
	
	/**
	 * Liste de tous les access de la base de données.
	 * @return Une liste des access de la base de données.
	 */
	public List<Learning_activity> findAll() {
		List<Learning_activity> cities = null;
		try {
			cities = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}
 
	/**
	 * Récupérer un access en particulier en fonction de son ID.
	 * @param id L'id de l'access.
	 * @return L'access correspondant à l'ID.
	 */
	public Learning_activity findById(int id) {
		Learning_activity city = null;
		try {
			city = (Learning_activity) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	/**
	 * Supprime un access.
	 * @param a L'access à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(Learning_activity a){
		return delete(a);
	}
	
	/**
	 * Le nombre d'access contenu dans la base de données.
	 * @return Le nombre d'access.
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
