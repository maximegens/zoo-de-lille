package com.platine.zoodelille.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platine.zoodelille.R;

public class AProposFragment extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_accueil, container, false);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("A Propos");
		builder.setMessage("Version 0.0 \nZoo de lille 2013 \nRéalisé par des étudiants de l'université Lille 1: \n		Olivier Debreu\n		Maxime Gens \n		Matthieu Poudroux \nFormation : Master Informatique E-Services \nTout droit réservé !")

               .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                   public void onClick(DialogInterface dialog, int id) {

                   }
               });

        // Create the AlertDialog object and return it
        builder.create();
        builder.show();

		return myInflatedView;
	}
}
