package com.platine.zoodelille.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.utils.Constantes;

public class MainActivity extends FragmentActivity {

	private String[] drawerItemsList;
	private ListView myDrawer;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private String categorieFragmentSave;
	private ActionBar actionBar;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
			
		/************* Creation du Drawer *************/
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		
		//Définition du contenu menu du Drawer
		drawerItemsList = getResources().getStringArray(R.array.items_slider);
		myDrawer = (ListView) findViewById(R.id.my_drawer);
		myDrawer.setAdapter(new ArrayAdapter<String>(this,R.layout.item_drawer, drawerItemsList));
	
		//rend l'icone de l'action bar cliquable
		actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		
		//permet de gérer le comportement du Drawer lors de sa fermeture et de son ouverture.
		mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_launcher, R.string.ouverture, R.string.fermeture) {
					public void onDrawerClosed(View view) {
						getActionBar().setTitle(nomCategorieActive(categorieFragmentSave));
						invalidateOptionsMenu();
					}
					public void onDrawerOpened(View drawerView) {
						getActionBar().setTitle(R.string.titre_menu_slider);
						invalidateOptionsMenu();
					}
				};
				
		//on affect les modifcations de l'actionBar au Drawer
		drawerLayout.setDrawerListener(mDrawerToggle);
		//on affect le listener au Drawer
		myDrawer.setOnItemClickListener(new MyDrawerItemClickListener());	
		
		//Lancement de l'accueil par défault et sauvegarde de l'etat
		FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
		if(savedInstanceState == null){
			tx.replace(R.id.frameLayout,Fragment.instantiate(MainActivity.this, Constantes.fragments[0]));
			categorieFragmentSave = Constantes.fragments[0];
		}else
			tx.replace(R.id.frameLayout,Fragment.instantiate(MainActivity.this, savedInstanceState.getString("categorieFragmentSave")));
        tx.commit();
        
	}

//	/**
//	 * Gérer la pression du bouton "Back" en demandant à l'utilisateur si il souhaite quitter l'application.
//	 */
//    public void onBackPressed() {
//
//    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(R.string.quitter_application)
//               .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int id) {
//                	   finish();
//                   }
//               })
//               .setNegativeButton("Non", new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int id) {
//                       
//                   }
//               });
//        builder.show();
//        
//    } 
	
	
	/**
	 * Methode excécutant du code lors du clique sur un item du Drawer. 
	 *
	 */
	private class MyDrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> adapter, View v, int pos, long id) {
			categorieFragmentSave = Constantes.fragments[pos];
			FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
			tx.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

			tx.replace(R.id.frameLayout, Fragment.instantiate(MainActivity.this, categorieFragmentSave));
			tx.commit();
			drawerLayout.closeDrawer(myDrawer);
		}
	}

	/**
	 * Methode gérant les retour de clique sur les items sur Drawer.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Récupére le tire du Fragment active, et applique se nom dans l'actionBar pour que l'utilisateur ai le titre de k=l a"page" sur laquelle il est.
	 * @param categorieFragmentSave Le nom de la catégorie sauvegardé et donc courante.
	 * @return Le nom formaté de la catégorie courante.
	 */
	public String nomCategorieActive(String categorieFragmentSave){
		
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.AccueilFragment"))
			return getResources().getString(R.string.app_name);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.AnimauxFragment"))
			return getResources().getString(R.string.animaux_du_zoo);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.PlanDuZooFragment"))
			return getResources().getString(R.string.plan_du_zoo);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.ActivitesPedagogiqueFragment"))
			return getResources().getString(R.string.activite_pedagogique);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.JeuxInteractifFragment"))
			return getResources().getString(R.string.jeux_interactif);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.PlanAccesFragment"))
			return getResources().getString(R.string.plan_acces);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.InformationsPratiqueFragment"))
			return getResources().getString(R.string.informations_pratique);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.AuxAlentoursFragment"))
			return getResources().getString(R.string.aux_alentours);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.ReglagesFragment"))
			return getResources().getString(R.string.reglages);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.ContactFragment"))
			return getResources().getString(R.string.contact);
		if(categorieFragmentSave.equals("com.platine.zoodelille.fragments.AProposFragment"))
			return getResources().getString(R.string.a_propos);
	
		return getResources().getString(R.string.app_name);
		
	}
	
	/**
	 * Methode de restauration des paramétres sauvegardés.
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		categorieFragmentSave = savedInstanceState.getString("categorieFragmentSave");
		actionBar.setTitle(nomCategorieActive(categorieFragmentSave));
	}
	
	/**
	 * Methode de sauvegarder des paramétres.
	 */
	@Override
	    protected void onSaveInstanceState(Bundle outState) {
        	outState.putString("categorieFragmentSave", categorieFragmentSave);
	        super.onSaveInstanceState(outState);
	    }
}