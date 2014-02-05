package com.platine.zoodelille.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.platine.zoodelille.R;
import com.platine.zoodelille.adapter.AnimalAdapter;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.dao.AnimalDao;

public class AnimauxFragment extends Fragment {
	
	private ListView listeViewAnimal;
	private List<Animal> lesanimaux;
	private AnimalDao animalDao;
	private AnimalAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_animaux, container, false);
		
		listeViewAnimal = (ListView) myInflatedView.findViewById(R.id.listViewAnimal);
		
		lesanimaux = new ArrayList<Animal>();
		animalDao = DatabaseManager.getDao().getAnimalDao();
		lesanimaux = animalDao.findAll();
		adapter = new AnimalAdapter(getActivity(), lesanimaux);
		listeViewAnimal.setAdapter(adapter);
		
		listeViewAnimal.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View view, int position, long id) {
				Animal a1 =  (Animal)listeViewAnimal.getItemAtPosition(position);
				FragmentAffichageAnimal fragment_affichage = new FragmentAffichageAnimal();
			    Bundle args = new Bundle();
			    args.putString("id", String.valueOf(a1.getId()));
			    fragment_affichage.setArguments(args);
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.frameLayout, fragment_affichage);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		
		return myInflatedView;
	}
}
