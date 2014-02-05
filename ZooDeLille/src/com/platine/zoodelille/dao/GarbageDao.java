package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Garbage;

public class GarbageDao extends BaseDaoImpl<Garbage, Integer> {
	public GarbageDao(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Garbage.class);
	}

	/**
	 * Sauvegarde une poubelle dans la base de données.
	 * 
	 * @param g garbage à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour
	 *         échec.
	 */
	public int save(Garbage g) {
		try {
			create(g);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Met à jour une poubelle.
	 * 
	 * @param g, la poubelle à sauvegarder.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1.
	 */
	public int update(Garbage g) {
		return update(g);
	}

	/**
	 * Liste de toutes les poubelles de la base de données.
	 * 
	 * @return Une liste des poubelles de la base de données.
	 */
	public List<Garbage> findAll() {
		List<Garbage> garbages = null;
		try {
			garbages = queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return garbages;
	}

	/**
	 * Récupérer une poubelle en particulier en fonction de son ID.
	 * 
	 * @param id, L'id de poubelle.
	 * @return La poubelle correspondante à l'ID.
	 */
	public Garbage findById(int id) {
		Garbage element = null;
		try {
			element = (Garbage) queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * Supprime une poubelle.
	 * 
	 * @param r, poubelle à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1. .
	 */
	public int delete(Garbage g) {
		return delete(g);
	}

	/**
	 * Le nombre de poubelles contenues dans la base de données.
	 * 
	 * @return Le nombre de poubelles.
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