package com.platine.zoodelille.fragments;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.meteo.ContainerData;
import com.platine.zoodelille.meteo.Entry;
import com.platine.zoodelille.utils.ConnexionInternet;
import com.platine.zoodelille.utils.Constantes;


public class AccueilFragment extends Fragment {
	
	TextView temperature;
	ImageView icone_temps;
	ProgressBar loader;;
	
	private RetreiveFeedMeteoTask retreiveFeedMeteoTask;
	private RetreiveFeedMeteoDataTask retreiveFeedMeteoDataTask;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View myInflatedView = inflater.inflate(R.layout.fragment_accueil, container,false);
		temperature = (TextView) myInflatedView.findViewById(R.id.temperature);	
		icone_temps = (ImageView) myInflatedView.findViewById(R.id.icone_temps);
		loader = (ProgressBar) myInflatedView.findViewById(R.id.progressBarMeteo);
		
		if(ConnexionInternet.isConnectedInternet(getActivity())){
			retreiveFeedMeteoTask = new RetreiveFeedMeteoTask();
			retreiveFeedMeteoTask.execute();
		}else{
			temperature.setPadding(50, 0, 0, 0);
			temperature.setTextSize(12);
			temperature.setText(Constantes.CONNEXION_INTERNET_FAILED);
		}

		return myInflatedView;
	}
	
	/** 
	 * AsynTask pour récupérer la temperature depuis la météo de Yahoo.
	 * 
	 **/
	private class RetreiveFeedMeteoDataTask extends AsyncTask<String, String, ArrayList<Entry>> {

	    protected ArrayList<Entry> doInBackground(String... textView) {
	    	ArrayList<Entry> entries = null;
	        try {
	        	entries = ContainerData.getFeeds();
	            return entries;
	        }catch (Exception e) {
	            return null;
	        }
	    }
	    protected void onPostExecute(ArrayList<Entry> entries) {
	    	if(entries != null)
	    		temperature.setText(entries.get(0).getTemperature()+Constantes.TEMPERATURE_C);
	    }
	}
	/** 
	 * AsynTask pour récupérer la météo de Yahoo 
	 * Cette AsynTask appel une autre asyntask qui récupere les données et grace à ces données, la asyntask ci-dessous met à jour l'icone météo.
	 **/
	private class RetreiveFeedMeteoTask extends AsyncTask<String, String, Bitmap> {

		Bitmap bitmap = null;
		
		@Override
		   protected void onPreExecute(){
			retreiveFeedMeteoDataTask = new RetreiveFeedMeteoDataTask();
			retreiveFeedMeteoDataTask.execute();
		   }
		
	    protected Bitmap doInBackground(String... code) {
	        try {
	    		URL urlImage = new URL(Constantes.URL_METEO_ICONE_DEBUT+retreiveFeedMeteoDataTask.get().get(0).getCodeImage()+Constantes.URL_METEO_ICONE_FIN);
				HttpURLConnection connection = (HttpURLConnection) urlImage.openConnection();
				InputStream inputStream = connection.getInputStream();
				bitmap = BitmapFactory.decodeStream(inputStream);
				return bitmap;
	        }catch (Exception e) {
	            return null;
	        }
	    }
	    protected void onPostExecute(Bitmap bitmap) {
	    	if(bitmap != null)
	    		icone_temps.setImageBitmap(bitmap);
	    	loader.setVisibility(View.INVISIBLE);
	    }
	}
}


