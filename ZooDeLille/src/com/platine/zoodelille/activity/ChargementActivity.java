package com.platine.zoodelille.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.platine.zoodelille.R;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.dao.AnimalCategoryDao;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;
import com.platine.zoodelille.dao.CountryDao;
import com.platine.zoodelille.dao.LocatableElementDao;
import com.platine.zoodelille.dao.PracticalInformationDao;
import com.platine.zoodelille.utils.RemplirBdd;

public class ChargementActivity extends FragmentActivity {

	private RetreiveAllData retreiveAllData;
	private ProgressBar loaderChargement;
	private ArticleDao articleDao;
	private PracticalInformationDao practicalInformationDao;
	ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chargement);
		
		loaderChargement = (ProgressBar)findViewById(R.id.progressBarChargement);	
		actionBar = getActionBar();
		getActionBar().hide();
					
		retreiveAllData = new RetreiveAllData(this);
		retreiveAllData.execute();
	}
	
	/** 
	 * AsynTask pour récupérer la temperature depuis la météo de Yahoo.
	 * 
	 **/
	private class RetreiveAllData extends AsyncTask<Void, Integer, Boolean> {
		private Activity activity;

	    public RetreiveAllData(Activity activity) {
			this.activity = activity;
		}

		protected void onPreExecute () {
	    	loaderChargement.setVisibility(View.VISIBLE);
	    }
		
		@Override
		protected Boolean doInBackground(Void... params) {
			
			/************* Creation et remplissage de la base de données *************/
			
			// initialisation du databaseManager, Obligatoire et à faire qu'une seule fois dans toutes l'application
			DatabaseManager.init(activity.getApplicationContext());
			
			articleDao = DatabaseManager.getDao().getArticleDao();
			practicalInformationDao = DatabaseManager.getDao().getPracticalInformationDao();
			LocatableElementDao locElmDao = DatabaseManager.getDao().getLocatableElementDao();
			AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
			AnimalCategoryDao animalCategoryDao = DatabaseManager.getDao().getAnimalCategoryDao();
			CountryDao countryDao = DatabaseManager.getDao().getCountryDao();
			
			// remplissage de  la base de données.
			
			if(locElmDao.count() == 0){
				RemplirBdd.addRestroom();
				RemplirBdd.addGarbages();
				RemplirBdd.addEnclosures();
			}
			if(animalCategoryDao.count() == 0){
				RemplirBdd.addAnimalCategories();
			}
			if(countryDao.count() == 0){
				RemplirBdd.addAnimalCountries();
			}
			
			if (animalDao.count() == 0) {
				RemplirBdd.ajouterDesAnimaux();
			}
			
			if (articleDao.count() == 0) {
				RemplirBdd.ajouterArticle();
			}
			if (practicalInformationDao.count() == 0) {
				RemplirBdd.ajouterPraticalInformation();
			}
			return true;
		}
	    
	    protected void onPostExecute(Boolean param) {
	    	Intent accueil = new Intent(activity, MainActivity.class);
	    	loaderChargement.setVisibility(View.INVISIBLE);
	    	activity.startActivity(accueil);
	    	activity.finish();
	    }
	}
}
