package com.platine.zoodelille.bdd;

import android.content.Context;
/**
 * Singleton Databasemanager, permet de n’avoir qu’une seule et même instance d’un objet tout au long d’une application.
 * Permet d'appeler les DAO sans isntancier plusieurs fois la classe databaseHelper.
 *
 */
public class DatabaseManager {
	
	static private DatabaseManager instance;
	 
	static public void init(Context context) {
		if(null==instance) {
			instance = new DatabaseManager(context);
		}
	}
 
	/**
	 * Permet d'obtenir une instance du singleton DatabaseManager.
	 * @return L'instance du DatabaseManager.
	 */
	static public DatabaseManager getInstance() {
		return instance;
	}
 
	private DatabaseHelper helper;
 
	private DatabaseManager(Context context) {
		helper = new DatabaseHelper(context);
	}
 
	/**
	 * Permet d'obtenir le helper, instance de databaseHelper.
	 * @return Le helper.
	 */
	public DatabaseHelper getHelper() {
		return helper;
	}
	
	/**
	 * Permet d'obtenir directement le helper sans passer par la méthode "getInstance" et de choisir son DAO.
	 * @return le helper.
	 */
	static public DatabaseHelper getDao(){
		return getInstance().getHelper();
	}
	
}
