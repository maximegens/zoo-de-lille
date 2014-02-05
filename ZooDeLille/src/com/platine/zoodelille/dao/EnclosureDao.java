package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import android.util.Log;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Enclosure;

public class EnclosureDao extends BaseDaoImpl<Enclosure, Integer> {
	public EnclosureDao(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Enclosure.class);
	}

	/**
	 * Sauvegarde un enclos dans la base de données.
	 * 
	 * @param e enclos à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour
	 *         échec.
	 */
	public int save(Enclosure e) {
		try {
			create(e);
			return 1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * Met à jour un enclos.
	 * 
	 * @param e, l'enclos à sauvegarder.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1.
	 */
	public int update(Enclosure e) {
		return update(e);
	}

	/**
	 * Liste de tous les enclos de la base de données.
	 * 
	 * @return Une liste des enclos de la base de données.
	 */
	public List<Enclosure> findAll() {
		List<Enclosure> enclosures = null;
		try {
			enclosures = queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enclosures;
	}

	/**
	 * Récupérer un enclos en particulier en fonction de son ID.
	 * 
	 * @param id, L'id de l'enclos.
	 * @return L'enclos correspondante à l'ID.
	 */
	public Enclosure findById(int id) {
		Enclosure element = null;
		try {
			element = (Enclosure) queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * Supprime un enclos.
	 * 
	 * @param e, enclos à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela
	 *         doit être 1. .
	 */
	public int delete(Enclosure e) {
		return delete(e);
	}

	/**
	 * Le nombre d'enclos contenus dans la base de données.
	 * 
	 * @return Le nombre d'enclos.
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
