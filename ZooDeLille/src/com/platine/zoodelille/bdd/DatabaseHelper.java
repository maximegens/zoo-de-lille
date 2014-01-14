package com.platine.zoodelille.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.utils.Constantes;

/**
 * 
 * Cette classe herite OrmLiteSqliteOpenHelper donc elle possède toutes les
 * Methodes permettant de faire  des opérations sur notre BD (ouverture, fermeture,...).
 * 
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = Constantes.DATABASE_NAME;
	// A chaque fois que la BD est modifie, cette version est incrémentée
	private static final int DATABASE_VERSION = 1;

	/** Declaration des DAO **/
	private AnimalDao animalDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Cette methode est appellée implicitement lors de la première création de la BD.
	 * C'est en ce moment que les tables de notre BD sont créées.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
	
			try {
				Log.i(DatabaseHelper.class.getName(), "Creation des tables");
				
				/** ajouter ici les tables à creers **/
				TableUtils.createTable(connectionSource, Animal.class);
				
			} catch (java.sql.SQLException e) {
				Log.e(DatabaseHelper.class.getName(), "Impossible de créer la BD", e);
			}
	}

	/**
	 * Cette methode est appellées lors de la mise à jour de la BD.
	 * L'anciènne est supprimée et la une nouvelle est crée avec une incrementation
	 * De la version de la BD.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
			
			try {
				onCreate(db, connectionSource);
				Log.i(DatabaseHelper.class.getName(), "Mise à jour de la DataBase");
				TableUtils.dropTable(connectionSource, Animal.class, true);
			} catch (java.sql.SQLException e) {
				Log.e(DatabaseHelper.class.getName(), "Impossible de supprimer la DataBase", e);
			}

	}

	/******* Déclarer toutes les methodes de récupération des DAO ******/
	
	public AnimalDao getAnimalDao() {
		if(null == animalDao) {
			try {
				animalDao = DaoManager.createDao(getConnectionSource(), Animal.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return animalDao;
	}

	/**
	 * Ferme la BD et nettoie le cache.
	 */
	@Override
	public void close() {
		super.close();
	}
}