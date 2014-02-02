package com.platine.zoodelille.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.utils.Constantes;


public class PlanAccesFragment extends Fragment {
	
	Button voiture;
	Button metro;
	Button bus;
	Button velo;
	ImageButton seRendreAuZoo;
	
	TextView acces;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_plan_acces, container, false);
		
		voiture = (Button)myInflatedView.findViewById(R.id.button_voiture);
		metro = (Button)myInflatedView.findViewById(R.id.button_metro);
		bus = (Button)myInflatedView.findViewById(R.id.button_bus);
		velo = (Button)myInflatedView.findViewById(R.id.button_velo);
		acces = (TextView)myInflatedView.findViewById(R.id.content_acces);
		seRendreAuZoo = (ImageButton)myInflatedView.findViewById(R.id.image_se_rendre_au_zoo);
		
		acces.setText("Par l’A1 et l’A22 : suivre Lille Centre Ville. Le zoo se trouve au bout du boulevard de la Liberté\n"
				+"Par l’A25 : sortie 5, Port Fluvial, suivre la direction Vauban et Citadelle.");	
		
		voiture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Par l’A1 et l’A22 : suivre Lille Centre Ville. Le zoo se trouve au bout du boulevard de la Liberté\n"
						+"Par l’A25 : sortie 5, Port Fluvial, suivre la direction Vauban et Citadelle.");	
			}
		});
		
		metro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Métro ligne 1 : station République ( à 15 mintues à pied)");	
			}
		});
		
		bus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Bus Liane 1 : arrêt champs de mars\n"
						+"Bus Liane 90 : arrêt champs de mars\n"
						+"Bus Liane 12 : arrêt Jardin Vauban");	
			}
		});
		
		velo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("V’Lille : station Jardin Vauban 1 min");	
			}
		});
		
		seRendreAuZoo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String lat = Constantes.COORDONNEES_GPS_ZOO_LATITUDE; 
				String lon = Constantes.COORDONNEES_GPS_ZOO_LONGITUDE;
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
					   Uri.parse("geo:"+lat+","+lon+"?z=17"));
				startActivity(intent);
			}
		});
		
		
		return myInflatedView;
	}
}
