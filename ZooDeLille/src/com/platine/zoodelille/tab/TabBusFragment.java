package com.platine.zoodelille.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.platine.zoodelille.R;

public class TabBusFragment extends Fragment {

	TextView acces;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.tab_plan_acces, container, false);
		
		acces = (TextView) myInflatedView.findViewById(R.id.textView_plan_acces);
		acces.setText("Vive les Bus");
		
		return myInflatedView;
	}

}