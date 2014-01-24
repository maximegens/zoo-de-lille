package com.platine.zoodelille.fragments;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.meteo.ContainerData;
import com.platine.zoodelille.meteo.Entry;
import com.platine.zoodelille.utils.Constantes;


public class AccueilFragment extends Fragment {
	
	TextView temperature;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View myInflatedView = inflater.inflate(R.layout.fragment_accueil, container,false);
		
		TextView t = (TextView) myInflatedView.findViewById(R.id.nom_categorie);
		temperature = (TextView) myInflatedView.findViewById(R.id.temperature);	
		t.setText("Bienvenue sur l'accueil");
		
        new RetreiveFeedMeteoTask().execute();
         
		return myInflatedView;
	}
	
	/** AsynTask pour récupérer la temperature depuis la météo de Yahoo **/
	private class RetreiveFeedMeteoTask extends AsyncTask<String, String, ArrayList<Entry>> {

	    protected ArrayList<Entry> doInBackground(String... textView) {
	    	ArrayList<Entry> entries = null;
	        try {
	        	entries = ContainerData.getFeeds();       
	            return entries;
	        } catch (Exception e) {
	            return null;
	        }
	    }
	    protected void onPostExecute(ArrayList<Entry> entry) {
	    	temperature.setText(entry.get(0).getTemperature()+Constantes.TEMPERATURE_C);
	    }

}
}


