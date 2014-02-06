package com.platine.zoodelille.fragments;

import com.platine.zoodelille.R;
import com.platine.zoodelille.adapter.ImageAdapter;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.Article;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.ArticleDao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class FragmentAffichageAnimal extends Fragment {
	
	private int idAnimal;
	private AnimalDao animalDao;
	private TextView animalName;
	private TextView animalDescription;
	private TextView animalEnvironnemet;
	private TextView animalPays;
	private TextView animalCategory;
	private TextView animalLongevity;
	private TextView animalprotect;
	private TextView animalGestation;
	private TextView animalPoids;
	private TextView animalCountry;
	private Integer[] tableau_image;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		
		View myInflatedView = inflater.inflate(R.layout.fragment_affichage_animal, container, false);
		
		Bundle args = getArguments();
		idAnimal = Integer.parseInt(args.getString("id"));
		
		animalName = (TextView) myInflatedView.findViewById(R.id.animalName);
		animalDescription = (TextView) myInflatedView.findViewById(R.id.description_information);	
		animalCountry = (TextView) myInflatedView.findViewById(R.id.animal_pays_information);		
		animalEnvironnemet = (TextView) myInflatedView.findViewById(R.id.animal_environnement_information);
		animalPoids = (TextView) myInflatedView.findViewById(R.id.animal_poids_information);
		animalCategory = (TextView) myInflatedView.findViewById(R.id.animal_category_information);	
		animalLongevity = (TextView) myInflatedView.findViewById(R.id.animal_longevite_information);
		animalGestation = (TextView) myInflatedView.findViewById(R.id.animal_gestation_information);
		animalprotect = (TextView) myInflatedView.findViewById(R.id.animal_protect_information);
		
		animalDao = DatabaseManager.getDao().getAnimalDao();		
		Animal a = animalDao.findById(idAnimal);
		
		animalName.setText(a.getName());
		animalDescription.setText(a.getDescription());
		animalCountry.setText(a.getCountry().getName());
		animalEnvironnemet.setText(a.getEnvironnement());
		animalPoids.setText(a.getWeight()+"");
		animalCategory.setText(a.getCategory().getName());
		animalLongevity.setText(a.getLongevity());
		animalGestation.setText(a.getGestation()+"");
		if(a.getProtected_animal()==1){
			animalprotect.setText("Oui");
		}
		else
			animalprotect.setText("Non");
		
		
//		if(a.getLien_image() != null){
//			int resID = getResources().getIdentifier(a.getLien_image(), "drawable", myInflatedView.getContext().getPackageName());
//			imgArticle.setImageResource(resID);
//		}else
//			imgArticle.setImageResource(R.drawable.no_image);

		
		String picture = a.getPicture_location();
		String[] tab_picture = picture.split(",");
		int resID=0;
		tableau_image = new Integer[tab_picture.length];
		for(int i =0;i<tab_picture.length;i++){
			resID = getResources().getIdentifier(tab_picture[i], "drawable", myInflatedView.getContext().getPackageName());
			tableau_image[i] = resID;
		}

		
		
		Gallery ga = (Gallery) myInflatedView.findViewById(R.id.gallery01);
		ga.setSpacing(10);
		
		
        ga.setAdapter(new ImageAdapter(getActivity(),tableau_image));
	
	return myInflatedView;
	
	}

}
