package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.PracticalInformation;

public class PracticalInformationDao extends
		BaseDaoImpl<PracticalInformation, Integer> {

	public PracticalInformationDao(ConnectionSource connectionSource)
			throws java.sql.SQLException {
		super(connectionSource, PracticalInformation.class);
	}

	/**
	 * Sauvegarde un practicalInformation dans la base de données.
	 * 
	 * @param a
	 *            L'practicalInformation à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour
	 *         échec.
	 */
	public int save(PracticalInformation a) {
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Met à jour un practicalInformation.
	 * 
	 * @param a
	 *            L'practicalInformation à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1.
	 */
	public int update(PracticalInformation a) {
		return update(a);
	}

	/**
	 * Liste de tous les practicalInformation de la base de données.
	 * 
	 * @return Une liste des practicalInformation de la base de données.
	 */
	public List<PracticalInformation> findAll() {
		List<PracticalInformation> cities = null;
		try {
			cities = queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}

	/**
	 * Récupérer un practicalInformation en particulier en fonction de son ID.
	 * 
	 * @param id
	 *            L'id de l'practicalInformation.
	 * @return L'practicalInformation correspondant à l'ID.
	 */
	public PracticalInformation findById(int id) {
		PracticalInformation city = null;
		try {
			city = (PracticalInformation) queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * Supprime un practicalInformation.
	 * 
	 * @param a
	 *            L'practicalInformation à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1. .
	 */
	public int delete(PracticalInformation a) {
		return delete(a);
	}

	/**
	 * Le nombre d'practicalInformation contenu dans la base de données.
	 * 
	 * @return Le nombre d'practicalInformation.
	 */
	public long count() {
		try {
			return countOf();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
