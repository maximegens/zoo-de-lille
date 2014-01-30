package com.platine.zoodelille.tab;

import com.platine.zoodelille.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabVoitureFragment extends Fragment {

	TextView acces;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.tab_plan_acces, container, false);
		
		acces = (TextView) myInflatedView.findViewById(R.id.textView_plan_acces);
		acces.setText("Vive les voitures");
		
		return myInflatedView;
	}

}