package com.platine.zoodelille.fragments;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.platine.zoodelille.R;

public class InformationsPratiqueFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView =  inflater.inflate(R.layout.fragment_informations_pratique, container, false);
		TextView ttitre = (TextView) myInflatedView.findViewById(R.id.titre);
		
		int nb = zooIsOpen();
		switch (nb){
		case 0: ttitre.setText("Fail !!!");
		case 1:	ttitre.setText("c'est pas bon du tout  !!!");
		case 2: ttitre.setText("GOOOOOOOOD !!!");
		}
		
		
		return myInflatedView;
	}
	
	
	
	public int zooIsOpen(){
		
		Calendar c = Calendar.getInstance();
		int date = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		int heure = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		
		
		
		if(Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK) && c.get(Calendar.DAY_OF_MONTH)>= 25)
		{
			if(c.get(Calendar.MONTH)>=Calendar.MARCH && c.get(Calendar.MONTH)<=Calendar.OCTOBER){
				// horaire d'eté
				return 1;
			}
			if(c.get(Calendar.MONTH)<=Calendar.MARCH && c.get(Calendar.MONTH)>=Calendar.OCTOBER){
				// horaire d'hiver
				return 2;
			}
		}
		
		
		return 0;
	}
}
