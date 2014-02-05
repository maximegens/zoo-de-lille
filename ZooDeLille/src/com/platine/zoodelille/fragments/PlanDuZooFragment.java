package com.platine.zoodelille.fragments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.beans.Enclosure;
import com.platine.zoodelille.beans.Garbage;
import com.platine.zoodelille.beans.Restroom;
import com.platine.zoodelille.dao.AnimalDao;
import com.platine.zoodelille.dao.EnclosureDao;
import com.platine.zoodelille.dao.GarbageDao;
import com.platine.zoodelille.dao.RestroomDao;

public class PlanDuZooFragment extends Fragment implements OnGlobalLayoutListener {
	protected List<Animal> animals;
	protected ActionListener action_listener;
	protected Spinner animals_spinner;
	protected ImageView position_image;
	
	protected HashMap<Integer, ImageView> garbages_img;
	protected HashMap<Integer, ImageView> restrooms_img;
	protected HashMap<Integer, ImageView> enclosures_img;
	protected HashMap<Integer, Enclosure> enclosures_table;
	
	protected TextView enclosure_info_tv;
	protected boolean is_garbages_created, is_restrooms_created, is_enclosures_created;
	protected RelativeLayout map_layout;
	
	protected Animal selected_animal;
	
	protected CheckBox enclosure_checkBox;
	protected CheckBox garbage_checkBox;
	protected CheckBox restroom_checkBox;
	
	
	/**
	 * Récupère les éléments définis dans le XML. Remplit également les listes de données brutes (les données présentes en base de données)
	 * La création des images à positionner sur la carte ne se fait que lorsque le fragment est rendu (sinon les dimensions des différents éléments sont nulles)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		action_listener = new ActionListener();
		View v = inflater.inflate(R.layout.fragment_plan_du_zoo, container, false);
		
		animals_spinner = (Spinner) v.findViewById(R.id.animal_selection);
		ArrayAdapter animals_adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item);
		animals_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		animals_spinner.setAdapter(animals_adapter);
		animals_spinner.setOnItemSelectedListener(action_listener);
		fillWithAnimals();
		
		
		map_layout = (RelativeLayout)v.findViewById(R.id.map_layout); 
		
		enclosure_info_tv = (TextView)v.findViewById(R.id.enclosure_info);
		
		enclosure_checkBox = (CheckBox)v.findViewById(R.id.show_enclosure);
		garbage_checkBox = (CheckBox)v.findViewById(R.id.show_garbage);
		restroom_checkBox = (CheckBox)v.findViewById(R.id.show_restroom);
		
		enclosure_checkBox.setOnCheckedChangeListener(action_listener);
		garbage_checkBox.setOnCheckedChangeListener(action_listener);
		restroom_checkBox.setOnCheckedChangeListener(action_listener);
		map_layout.getViewTreeObserver().addOnGlobalLayoutListener(this);
		fillEnclosures();
		return v;
	}

	public void onResume()
	{
		super.onResume();
		//Blocage de l'activité en mode portrait
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	public void onPause()
	{
		super.onPause();
		//Déblocage de l'activité en mode portrait
		getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
	}
	
	/**
	 * Récupération de la liste des animaux de la base de données
	 */
	protected void fillWithAnimals()
	{
		List<String> animals_name = new ArrayList<String>();
		AnimalDao animalDao = DatabaseManager.getDao().getAnimalDao();
		animals = animalDao.findAll();
		ArrayAdapter animals_adapter = (ArrayAdapter) animals_spinner.getAdapter();
		animals_adapter.clear();
		
		animals_name.add("Sélectionner un animal");
		for(Animal a : animals)
			animals_name.add(a.getName());
		
		animals_adapter.addAll(animals_name);
		
		
	}
	
	/**
	 * Création des images de poubelles
	 */
	protected void createGarbagesViews()
	{
		double x, y;
		GarbageDao gDao = DatabaseManager.getDao().getGarbageDao();
		int nb_g = (int) gDao.count();
		ImageView curr_img;
		List<Garbage> garbages = gDao.findAll();
		
		garbages_img = new HashMap<Integer, ImageView>();
		
		for (int i=0; i<nb_g; i++)
		{
			x = garbages.get(i).getLocatable_element().getX_location();
			y = garbages.get(i).getLocatable_element().getY_location();
			curr_img = create_img(R.drawable.icon_garbage, x, y);
			garbages_img.put(garbages.get(i).getId(), curr_img);
		}
		
		is_garbages_created = true;
	}
	
	/**
	 * Créations des images de toilettes
	 */
	protected void createRestroomsViews()
	{
		double x, y;
		RestroomDao rDao = DatabaseManager.getDao().getRestroomDao(); 
		int nb_r = (int) rDao.count();
		ImageView curr_img;
		List<Restroom> restrooms = rDao.findAll(); 
		
		restrooms_img = new HashMap<Integer, ImageView>();
	
		for (int i=0; i<nb_r; i++)
		{
	
			x = restrooms.get(i).getLocatable_element().getX_location();
			y = restrooms.get(i).getLocatable_element().getY_location();		
			curr_img = create_img(R.drawable.icon_restroom, x, y);
			restrooms_img.put(restrooms.get(i).getId(), curr_img);
		}
		
		is_restrooms_created = true;
	}
	
	/**
	 * Récupération des enclos de la base de données
	 */
	protected void fillEnclosures()
	{
		EnclosureDao eDao = DatabaseManager.getDao().getEnclosureDao();
		List<Enclosure> enclosures = eDao.findAll();
		enclosures_table = new HashMap<Integer, Enclosure>();
		for(Enclosure e : enclosures)
			enclosures_table.put(e.getId(), e);
	}
	
	/**
	 * Création des images d'enclos
	 */
	protected void createEnclosuresViews()
	{
		double x, y;
		EnclosureDao eDao = DatabaseManager.getDao().getEnclosureDao();
		int nb_e = (int) eDao.count();
		List<Enclosure> enclosures = eDao.findAll();
		ImageView curr_img;
		enclosures_img = new HashMap<Integer, ImageView>();
		
		for (int i=0; i<nb_e; i++)
		{
			
			x = enclosures.get(i).getLocatable_element().getX_location();
			y = enclosures.get(i).getLocatable_element().getY_location();
		
			curr_img = create_img(R.drawable.icon_enclosure, x, y);
			curr_img.setOnClickListener(action_listener);
			enclosures_img.put(enclosures.get(i).getId(), curr_img);
		}
		
		is_enclosures_created = true;
	}
	
	/**
	 * Permet de créer et de placer une image à partir de sa position (en pourcentage x et y par rapport au layout)
	 * @param res_id
	 * @param x_percent_on_layout
	 * @param y_percent_on_layout
	 * @return image fraichement créée
	 */
	protected ImageView create_img(int res_id, double x_percent_on_layout, double y_percent_on_layout)
	{
		RelativeLayout.LayoutParams layout_params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ImageView img = new ImageView(getActivity());
		
		img.setImageResource(res_id);
		
		int x, y;
		//convertion d'un positionnement en pourcentage de largeur/hauteur de layout vers le positionnement X/Y réel
		x = (int) Math.round(map_layout.getWidth()/100F*x_percent_on_layout)-img.getDrawable().getIntrinsicWidth()/2;
		y = (int) Math.round(map_layout.getHeight()/100F*y_percent_on_layout)-img.getDrawable().getIntrinsicHeight()/2;

		img.setTranslationX(x);
		img.setTranslationY(y);
		
		Log.d("add_img.x_loc", String.valueOf(x));
		Log.d("add_img.y_loc", String.valueOf(y));
	
		map_layout.addView(img, layout_params);
		
		return img;
	}
	
	/**
	 * Permet de changer la visibilité d'un type d'éléments localiables
	 * @param loc_elms_hashMap
	 * @param visibility
	 */

	protected void setLocatableElementVisibility(HashMap<Integer, ImageView> loc_elms_hashMap, int visibility)
	{
		Collection<ImageView> loc_elms = loc_elms_hashMap.values();
		for(ImageView img : loc_elms)
			img.setVisibility(visibility);
	}
	
	/**
	 * onGlobalLayout() est appelé une fois que les vues ont été graphiquement rendus.
	 * L'appel signifie que les layouts ont à présent une largeur et hauteur
	 */
	@Override
	public void onGlobalLayout() {
		//création et positionnement des images des éléments localisables
		if(!is_garbages_created)
			createGarbagesViews();
		
		if(!is_restrooms_created)
			createRestroomsViews();
		
		if(!is_enclosures_created)
			createEnclosuresViews();
		
		map_layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
	}
	
	/**
	 * Sélectionne un animal et applique les conséquences (exemple: sélection de l'enclos correspondant)
	 * @param animal
	 */
	public void setSelected_animal(Animal animal)
	{
		this.selected_animal = animal;
		
		selectEnclosure(animal.getEnclosure().getId());
		
		
	}
	
	/**
	 * Désélectionne un animal
	 */
	public void unselectAnimal()
	{
		this.selected_animal = null;
		
		if(animals_spinner.getSelectedItemPosition() != 0)
			animals_spinner.setSelection(0);
	}
	
	public Animal getSelected_animal()
	{
		return selected_animal;
	}
	
	/**
	 * Selectionne un enclos 
	 * @param id
	 */
	public void selectEnclosure(int id)
	{
		unselectAllEnclosure();
		ImageView enclosure_img = enclosures_img.get(id);
		enclosure_img.setImageResource(R.drawable.icon_enclosure_selected);
		enclosure_info_tv.setText(enclosures_table.get(id).getName());
	}
	
	/**
	 * Désélectionne un enclos
	 * @param id
	 */
	public void unselectEnclosure(int id)
	{
		ImageView enclosure_img = enclosures_img.get(id);
		
		enclosure_img.setImageResource(R.drawable.icon_enclosure);
		enclosure_info_tv.setText(getResources().getString(R.string.default_enclosure));
		
	}
	
	
	/**
	 * Désélectionne tous les enclos
	 */
	public void unselectAllEnclosure()
	{
		Collection<ImageView> enclosures_to_unselect = enclosures_img.values();
		for(ImageView e : enclosures_to_unselect)
			e.setImageResource(R.drawable.icon_enclosure);
		
		enclosure_info_tv.setText(getResources().getString(R.string.default_enclosure));
	}
	
	/**
	 * ActionListener est la classe qui gère les callbacks des événements des vues
	 *
	 */
	private class ActionListener implements OnClickListener, OnCheckedChangeListener, OnItemSelectedListener
	{

		/**
		 * Gestion de la visibilité des éléments localisables
		 */
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			int visibility = isChecked ? View.VISIBLE : View.INVISIBLE;
			
			if(buttonView.equals(enclosure_checkBox))
				setLocatableElementVisibility(enclosures_img, visibility);
			else if (buttonView.equals(restroom_checkBox))
				setLocatableElementVisibility(restrooms_img, visibility);
			else if (buttonView.equals(garbage_checkBox))
				setLocatableElementVisibility(garbages_img, visibility);
			
		}

		/**
		 * Gestion de la sélection d'animaux
		 */
		@Override
		public void onItemSelected(AdapterView<?> adapter, View v, int pos,
				long arg3) {
		
			if(pos > 0)
			{
				setSelected_animal(animals.get(pos-1));
			}
			else
			{
				unselectAnimal();
			}
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * Gestion des sélections d'enclos
		 */
		@Override
		public void onClick(View v) {
			int enclosure_id = -1;
			for(Map.Entry entry : enclosures_img.entrySet())
			{
				if (entry.getValue().equals(v))
				{
					enclosure_id = (Integer) entry.getKey();
					break;
				}
			}
			
			if(enclosure_id > -1)
			{
				unselectAnimal();
				selectEnclosure(enclosure_id);
			}
		}
	}
}