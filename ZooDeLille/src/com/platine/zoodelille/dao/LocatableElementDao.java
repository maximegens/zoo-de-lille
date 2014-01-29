package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.LocatableElement;

public class LocatableElementDao extends BaseDaoImpl<LocatableElement,Integer> {
	public LocatableElementDao(ConnectionSource connectionSource)
		throws SQLException {
		super(connectionSource, LocatableElement.class);
	}
 
	/**
	 * Sauvegarde un LocatableElement dans la base de données.
	 * @param locatable_element, l'emplacement à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(LocatableElement locatable_element){
		try {
			create(locatable_element);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un LocatableElement.
	 * @param locatable_element, l'emplacement à sauvegarder.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(LocatableElement locatable_element){
		return update(locatable_element);
	}
	
	/**
	 * Liste de tous les elements localisables de la base de données.
	 * @return Une liste des elements localisables de la base de données.
	 */
	public List<LocatableElement> findAll() {
		List<LocatableElement> elements = null;
		try {
			elements = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return elements;
	}
 
	/**
	 * Récupérer un element localisable en particulier en fonction de son ID.
	 * @param id L'id de l'element localisable.
	 * @return L'element localisable correspondant à l'ID.
	 */
	public LocatableElement findById(int id) {
		LocatableElement element = null;
		try {
			element = (LocatableElement) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	/**
	 * Supprime un LocatableElement.
	 * @param LocatableElement à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(LocatableElement element){
		return delete(element);
	}
	
	/**
	 * Le nombre d'element localisable contenus dans la base de données.
	 * @return Le nombre d'element localisable.
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
