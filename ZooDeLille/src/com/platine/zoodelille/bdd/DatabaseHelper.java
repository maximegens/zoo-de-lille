package com.platine.zoodelille.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.AnimalCategory;
import com.platine.zoodelille.beans.Article;
import com.platine.zoodelille.beans.Country;
import com.platine.zoodelille.beans.Enclosure;
import com.platine.zoodelille.beans.Garbage;
import com.platine.zoodelille.beans.LocatableElement;
import com.platine.zoodelille.beans.PracticalInformation;
import com.platine.zoodelille.beans.Restroom;
import com.platine.zoodelille.dao.AnimalCategoryDao;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;
import com.platine.zoodelille.dao.CountryDao;
import com.platine.zoodelille.dao.EnclosureDao;
import com.platine.zoodelille.dao.GarbageDao;
import com.platine.zoodelille.dao.LocatableElementDao;
import com.platine.zoodelille.dao.PracticalInformationDao;
import com.platine.zoodelille.dao.RestroomDao;
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
	private CountryDao countryDao = null;
	private AnimalCategoryDao animalCategoryDao = null;
	private AnimalDao animalDao = null;

	private ArticleDao articleDao = null;
	private PracticalInformationDao practicalInformationDao = null;

	private EnclosureDao enclosureDao = null;
	private GarbageDao garbageDao = null;
	private RestroomDao restroomDao = null;
	private LocatableElementDao locElmDao = null;


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
				TableUtils.createTable(connectionSource, AnimalCategory.class);
				TableUtils.createTable(connectionSource, Country.class);
				TableUtils.createTable(connectionSource, Animal.class);
				TableUtils.createTable(connectionSource, Article.class);
				TableUtils.createTable(connectionSource, PracticalInformation.class);
				TableUtils.createTable(connectionSource, LocatableElement.class);
				TableUtils.createTable(connectionSource, Enclosure.class);
				TableUtils.createTable(connectionSource, Garbage.class);
				TableUtils.createTable(connectionSource, Restroom.class);
				
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
				Log.i(DatabaseHelper.class.getName(), "Mise à jour de la DataBase");
				TableUtils.dropTable(connectionSource, Animal.class, true);
				TableUtils.dropTable(connectionSource, AnimalCategory.class, true);
				TableUtils.dropTable(connectionSource, Country.class, true);
				TableUtils.dropTable(connectionSource, LocatableElement.class, true);
				TableUtils.dropTable(connectionSource, Enclosure.class, true);
				TableUtils.dropTable(connectionSource, Garbage.class, true);
				TableUtils.dropTable(connectionSource, Restroom.class, true);
				onCreate(db, connectionSource);
			} catch (java.sql.SQLException e) {
				Log.e(DatabaseHelper.class.getName(), "Impossible de supprimer la DataBase", e);
			}

	}

	/******* Déclarer toutes les methodes de récupération des DAO ******/
	
	public AnimalCategoryDao getAnimalCategoryDao()
	{
		if(null == animalCategoryDao) {
			try {
				animalCategoryDao = DaoManager.createDao(getConnectionSource(), AnimalCategory.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return animalCategoryDao;
	}
	
	public CountryDao getCountryDao()
	{
		if(null == countryDao) {
			try {
				countryDao = DaoManager.createDao(getConnectionSource(), Country.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return countryDao;
	}
	
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
	

	public ArticleDao getArticleDao() {
		if(null == articleDao) {
			try {
				articleDao = DaoManager.createDao(getConnectionSource(), Article.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return articleDao;
	}
	public PracticalInformationDao getPracticalInformationDao() {
		if(null == practicalInformationDao) {
			try {
				practicalInformationDao = DaoManager.createDao(getConnectionSource(), PracticalInformation.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return practicalInformationDao;
	}

	public EnclosureDao getEnclosureDao() {
		if(null == enclosureDao) {
			try {
				enclosureDao = DaoManager.createDao(getConnectionSource(), Enclosure.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return enclosureDao;
	}
	
	public GarbageDao getGarbageDao() {
		if(null == garbageDao) {
			try {
				garbageDao = DaoManager.createDao(getConnectionSource(), Garbage.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return garbageDao;
	}
	
	public RestroomDao getRestroomDao() {
		if(null == restroomDao) {
			try {
				restroomDao = DaoManager.createDao(getConnectionSource(), Restroom.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return restroomDao;
	}
	
	public LocatableElementDao getLocatableElementDao() {
		if(null == locElmDao) {
			try {
				locElmDao = DaoManager.createDao(getConnectionSource(), LocatableElement.class);
			}catch(java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return locElmDao;
	}


	/**
	 * Ferme la BD et nettoie le cache.
	 */
	@Override
	public void close() {
		super.close();
	}
}