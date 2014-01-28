package com.platine.zoodelille.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.platine.zoodelille.R;

public class PlanAccesFragment extends Fragment {
	
	private TabHost tabHost;
	private TabSpec tabSpec = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_plan_acces, container, false);
		
//		TextView tAccessadresse = (TextView) myInflatedView.findViewById(R.id.Accessadresse);
//		tAccessadresse.setText("Le Parc Zoologique de Lille est situé dans le Parc de la Citadelle, Avenue Mathias Delobel.");
//		
//		TextView tacess = (TextView) myInflatedView.findViewById(R.id.acess);
//		tacess.setText("Comment accéder :");
		
		Intent intent = new Intent();
		
		tabHost = (TabHost) myInflatedView.findViewById(android.R.id.tabhost);
		tabHost.setup();
		
		/**
		 * Ajoute les différentes partie du tableau.
		 */
		
		//voiture
		//intent.putExtra("valeur", "• Par l’A1 et l’A22 : suivre Lille Centre Ville. Le zoo se trouve au bout du boulevard de la Liberté.• Par l’A25 : sortie 5, Port Fluvial, suivre la direction Vauban et Citadelle.");
		//tabSpec = tabHost.newTabSpec("plop");
		//tabSpec.setIndicator("plop");
		//tabSpec = tabHost.newTabSpec("Voiture").setIndicator("Voiture").setContent(intent);
		//tabHost.addTab(tabSpec);
		
//		//metro
//		intent.putExtra("valeur", "Métro ligne 1 : station République ( à 15 mintues à pied ou Bus (Ligne 12, liane 1)).");
//		tabSpec = tabHost.newTabSpec("Metro").setIndicator("Metro").setContent(intent);
//		tabHost.addTab(tabSpec);
//
//		
//		//Bus
//		intent.putExtra("valeur", "• Bus Liane 1 : arrêt champs de mars • Bus Liane 90 : arrêt champs de mars • Bus Liane 12 : arrêt Jardin Vauban.");
//		tabSpec = tabHost.newTabSpec("Bus").setIndicator("Bus").setContent(intent);
//		tabHost.addTab(tabSpec);
//
//		
//		//Vlille
//		intent.putExtra("valeur", "Station Jardin Vauban.");
//		tabSpec = tabHost.newTabSpec("VLille").setIndicator("VLille").setContent(intent);
//		tabHost.addTab(tabSpec);
		
		// Affecte au bouton le lancement de Gmap 
		Button goToZoo= (Button) myInflatedView.findViewById(R.id.goToZooButton);
		goToZoo.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	double latitude = 50.638221;
            	double longitude = 3.04724;
            	String name = "Zoo de lille";
            	 
            	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+ latitude +", "+ longitude +"?q="+ latitude +", "+ longitude +"("+ name +")"));
                startActivity(intent);
            }
         });

		
		return myInflatedView;
	}
}
