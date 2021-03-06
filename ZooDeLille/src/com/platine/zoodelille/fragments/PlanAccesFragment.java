package com.platine.zoodelille.fragments;

import android.content.Intent;
import android.graphics.Typeface;
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
		
		voiture.setTextColor(getResources().getColor(R.color.a_la_une));
		voiture.setTypeface(null, Typeface.BOLD);
		acces.setTypeface(null, Typeface.BOLD);
	
		voiture.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Par l’A1 et l’A22 : suivre Lille Centre Ville. Le zoo se trouve au bout du boulevard de la Liberté\n"
						+"Par l’A25 : sortie 5, Port Fluvial, suivre la direction Vauban et Citadelle.");
				
				voiture.setTextColor(getResources().getColor(R.color.a_la_une));
				voiture.setTypeface(null, Typeface.BOLD);
				
				metro.setTextColor(getResources().getColor(R.color.Black));
				metro.setTypeface(null, Typeface.NORMAL);
				bus.setTextColor(getResources().getColor(R.color.Black));
				bus.setTypeface(null, Typeface.NORMAL);
				velo.setTextColor(getResources().getColor(R.color.Black));
				velo.setTypeface(null, Typeface.NORMAL);
			
			}
		});
		
		metro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Métro ligne 1 : station République ( à 15 mintues à pied)");	
				
				metro.setTextColor(getResources().getColor(R.color.a_la_une));
				metro.setTypeface(null, Typeface.BOLD);
				
				voiture.setTextColor(getResources().getColor(R.color.Black));
				voiture.setTypeface(null, Typeface.NORMAL);
				bus.setTextColor(getResources().getColor(R.color.Black));
				bus.setTypeface(null, Typeface.NORMAL);
				velo.setTextColor(getResources().getColor(R.color.Black));
				velo.setTypeface(null, Typeface.NORMAL);
			}
		});
		
		bus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("Bus Liane 1 : arrêt champs de mars\n"
						+"Bus Liane 90 : arrêt champs de mars\n"
						+"Bus Liane 12 : arrêt Jardin Vauban");	
				
				bus.setTextColor(getResources().getColor(R.color.a_la_une));
				bus.setTypeface(null, Typeface.BOLD);
				
				voiture.setTextColor(getResources().getColor(R.color.Black));
				voiture.setTypeface(null, Typeface.NORMAL);
				metro.setTextColor(getResources().getColor(R.color.Black));
				metro.setTypeface(null, Typeface.NORMAL);
				velo.setTextColor(getResources().getColor(R.color.Black));
				velo.setTypeface(null, Typeface.NORMAL);
			}
		});
		
		velo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				acces.setText("V’Lille : station Jardin Vauban 1 min");	
				
				velo.setTextColor(getResources().getColor(R.color.a_la_une));
				velo.setTypeface(null, Typeface.BOLD);
				
				voiture.setTextColor(getResources().getColor(R.color.Black));
				voiture.setTypeface(null, Typeface.NORMAL);
				metro.setTextColor(getResources().getColor(R.color.Black));
				metro.setTypeface(null, Typeface.NORMAL);
				bus.setTextColor(getResources().getColor(R.color.Black));
				bus.setTypeface(null, Typeface.NORMAL);
			}
		});
		
		seRendreAuZoo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String lat = Constantes.COORDONNEES_GPS_ZOO_LATITUDE; 
				String lon = Constantes.COORDONNEES_GPS_ZOO_LONGITUDE;
				String lat_user = String.valueOf(Constantes.GPS_LAT_USER); 
				String lon_user = String.valueOf(Constantes.GPS_LONG_USER);
				
				Intent intentPositionToZoo = new Intent(android.content.Intent.ACTION_VIEW, 
					   Uri.parse("http://maps.google.com/maps?saddr="+lat+","+lon+"&daddr="+lat_user+","+lon_user));
				startActivity(intentPositionToZoo);
			}
		});
			
		return myInflatedView;
	}
}
