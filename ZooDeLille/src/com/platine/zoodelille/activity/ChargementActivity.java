package com.platine.zoodelille.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.platine.zoodelille.R;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;
import com.platine.zoodelille.dao.LocatableElementDao;
import com.platine.zoodelille.dao.PracticalInformationDao;
import com.platine.zoodelille.utils.RemplirBdd;

public class ChargementActivity extends FragmentActivity {

	private RetreiveAllData retreiveAllData;
	private ProgressBar loaderChargement;
	private ArticleDao articleDao;
	private PracticalInformationDao practicalInformationDao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chargement);
		
		loaderChargement = (ProgressBar)findViewById(R.id.progressBarChargement);
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
			
			// remplissage de  la base de données.
			
			LocatableElementDao locElmDao = DatabaseManager.getDao().getLocatableElementDao();
			
			if(locElmDao.count() == 0)
			{
				Log.v("----- MainActivity", "Remplissage de la bdd en Elements localisables");
				
				RemplirBdd.addRestroom();
				RemplirBdd.addGarbages();
				RemplirBdd.addEnclosures();
		
			}
			
			Log.v("----- MainActivity", "Il y a "+locElmDao.count()+" elements localisables dans la bdd");
			
			AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
			
			// ajout des animaux dans la base si celle ci est vide
			if (animalDao.count() == 0) {
				Log.v("----- MainActivity", "Remplissage de la bdd en Animaux");
				RemplirBdd.ajouterDesAnimaux();
				
			}
			
			Log.v("----- MainActivity", "Il y a "+animalDao.count()+" animaux dans la bdd");
			
			if (articleDao.count() == 0) {
				RemplirBdd.ajouterArticle();
			}
			if (practicalInformationDao.count() == 0) {
				RemplirBdd.ajouterPraticalInformation();
			}
			return true;
		}
	    
	    protected void onPostExecute(Boolean param) {
	    	loaderChargement.setVisibility(View.INVISIBLE);
	    	Intent accueil = new Intent(activity, MainActivity.class);
	    	activity.startActivity(accueil);
	    	activity.finish();
	    }

	}
}