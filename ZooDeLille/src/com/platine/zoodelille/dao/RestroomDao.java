package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Restroom;

public class RestroomDao extends BaseDaoImpl<Restroom, Integer> {
	public RestroomDao(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Restroom.class);
	}

	/**
	 * Sauvegarde un toilette dans la base de données.
	 * 
	 * @param r restroom à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour
	 *         échec.
	 */
	public int save(Restroom r) {
		try {
			create(r);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Met à jour un Restroom.
	 * 
	 * @param r, le restroom à sauvegarder.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1.
	 */
	public int update(Restroom r) {
		return update(r);
	}

	/**
	 * Liste de tous les toilettes de la base de données.
	 * 
	 * @return Une liste des toilettes de la base de données.
	 */
	public List<Restroom> findAll() {
		List<Restroom> restrooms = null;
		try {
			restrooms = queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restrooms;
	}

	/**
	 * Récupérer un toilette en particulier en fonction de son ID.
	 * 
	 * @param id, L'id de toilette.
	 * @return Le toilette correspondant à l'ID.
	 */
	public Restroom findById(int id) {
		Restroom element = null;
		try {
			element = (Restroom) queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * Supprime un toilette.
	 * 
	 * @param r, toilette à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1. .
	 */
	public int delete(Restroom r) {
		return delete(r);
	}

	/**
	 * Le nombre de toilettes contenus dans la base de données.
	 * 
	 * @return Le nombre de toilettes.
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