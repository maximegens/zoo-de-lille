package com.platine.zoodelille.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.platine.zoodelille.R;

public class AccueilFragment extends Fragment {
	TextView text;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View myInflatedView = inflater.inflate(R.layout.fragment_accueil, container,false);
		
		TextView t = (TextView) myInflatedView.findViewById(R.id.nom_categorie);
		t.setText("Bienvenue sur l'accueil");
		
		return myInflatedView;
	}
}
