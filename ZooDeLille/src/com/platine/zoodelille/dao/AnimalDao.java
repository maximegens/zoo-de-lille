package com.platine.zoodelille.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.platine.zoodelille.beans.Animal;

/**
 * Classe Dao des Animauxs, permet l'accés aux données contenu dans la base de données pour la table Animal. 
 *
 */
public class AnimalDao extends BaseDaoImpl<Animal,Integer>{
	public AnimalDao(ConnectionSource connectionSource)
		throws SQLException {
		super(connectionSource, Animal.class);
	}
 
	/**
	 * Sauvegarde un Animal dans la base de données.
	 * @param a L'animal à sauvegarder.
	 * @return Le résultat de l'insertion, 1 pour insertion réussi, 0 pour échec.
	 */
	public int save(Animal a){
		try {
			create(a);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Met à jour un Animal.
	 * @param a L'animal à mettre à jour.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
	 */
	public int update(Animal a){
		return update(a);
	}
	
	/**
	 * Liste de tous les animaux de la base de données.
	 * @return Une liste des animaux de la base de données.
	 */
	public List<Animal> findAll() {
		List<Animal> cities = null;
		try {
			cities = queryForAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}
 
	/**
	 * Récupérer un animal en particulier en fonction de son ID.
	 * @param id L'id de l'animal.
	 * @return L'animal correspondant à l'ID.
	 */
	public Animal findById(int id) {
		Animal city = null;
		try {
			city = (Animal) queryForId(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	/**
	 * Supprime un animal.
	 * @param a L'animal à supprimer.
	 * @return Le nombre de lignes mises à jour dans la base de données. Cela doit être 1.
.	 */
	public int delete(Animal a){
		return delete(a);
	}
	
	/**
	 * Le nombre d'animaux contenu dans la base de données.
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