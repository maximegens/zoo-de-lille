package com.platine.zoodelille.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platine.zoodelille.R;
import com.platine.zoodelille.activity.MainActivity;
import com.platine.zoodelille.utils.Constantes;

public class AProposFragment extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_a_propos, container, false);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("A Propos");
		builder.setMessage("Version 0.0 \nZoo de lille 2013 \nRéalisé par des étudiants de l'université Lille 1: \n    Olivier Debreu \n    Maxime Gens \n    Matthieu Poudroux \nFormation : Master Informatique E-Service \n\nTout droit réservé !")

               .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                   public void onClick(DialogInterface dialog, int id) {
                	   
                	String categorieFragmentSave = Constantes.fragments[0];
           			FragmentTransaction tx = getFragmentManager().beginTransaction();
           			tx.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
           			tx.replace(R.id.frameLayout, Fragment.instantiate(getActivity(), categorieFragmentSave));
           			tx.commit();
                       
                   }
               });

        // Create the AlertDialog object and return it
        builder.create();
        builder.show();

        
		
		
		return myInflatedView;
	}
}
