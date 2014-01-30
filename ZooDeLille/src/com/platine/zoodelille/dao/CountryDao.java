package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Country;

public class CountryDao extends BaseDaoImpl<Country,Integer>  {
	
	public CountryDao(ConnectionSource connectionSource)
			throws java.sql.SQLException {
			super(connectionSource, Country.class);
		}
 
	/**
	 * Sauvegarde un country dans la base de données.
	 * @param le country à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(Country a){
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un country.
	 * @param a L'country à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(Country a){
		return update(a);
	}
	
	/**
	 * Liste de tous les country de la base de données.
	 * @return Une liste des country de la base de données.
	 */
	public List<Country> findAll() {
		List<Country> cities = null;
		try {
			cities = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}
 
	/**
	 * Récupérer un country en particulier en fonction de son ID.
	 * @param id L'id de l'country.
	 * @return la country correspondant à l'ID.
	 */
	public Country findById(int id) {
		Country city = null;
		try {
			city = (Country) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	/**
	 * Supprime un country.
	 * @param la country à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(Country a){
		return delete(a);
	}
	
	/**
	 * Le nombre de country contenu dans la base de données.
	 * @return Le nombre de country.
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
