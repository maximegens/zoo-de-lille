package com.platine.zoodelille.fragments;

import java.util.List;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.PracticalInformation;
import com.platine.zoodelille.dao.PracticalInformationDao;
import com.platine.zoodelille.utils.Constantes;
import com.platine.zoodelille.utils.HoraireZoo;

public class InformationsPratiqueFragment extends Fragment {
	
	ImageView voyant;
	TextView etatZoo;
	TextView prochaineOuverture;
	TextView contentSummerWinterHoraire;
	TextView closedAnnuel;
	HoraireZoo horaireZoo;
	PracticalInformationDao practicalInformationDao;
	List<PracticalInformation> lespracticalInformationDao;
	PracticalInformation p;
	Button summer;
	Button winter;
	String horaireSummer;
	String horaireWinter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView =  inflater.inflate(R.layout.fragment_informations_pratique, container, false);
		voyant = (ImageView)myInflatedView.findViewById(R.id.voyantZooInfoPratique);
		etatZoo = (TextView)myInflatedView.findViewById(R.id.etatZooInfoPratique);
		prochaineOuverture = (TextView)myInflatedView.findViewById(R.id.prochaineOuvertureInfopratique);
		contentSummerWinterHoraire = (TextView)myInflatedView.findViewById(R.id.content_summer_winter_horaire);
		closedAnnuel = (TextView)myInflatedView.findViewById(R.id.fermeture_annuelle);
		summer = (Button)myInflatedView.findViewById(R.id.button_summer);
		winter = (Button)myInflatedView.findViewById(R.id.button_winter);
			
		horaireZoo = new HoraireZoo();
		if(horaireZoo.zooIsOpen()){
			voyant.setImageDrawable(getResources().getDrawable(R.drawable.voyant_vert));
			etatZoo.setText(getResources().getString(R.string.ouvert));
			etatZoo.setTextColor(getResources().getColor(R.color.zoo_ouvert));
			etatZoo.setTextSize(18);
			prochaineOuverture.setText(Constantes.PROCHAIN_HORAIRE+horaireZoo.getNextOpenning());
		}else{
			voyant.setImageDrawable(getResources().getDrawable(R.drawable.voyant_rouge));
			etatZoo.setText(getResources().getString(R.string.ferme));
			etatZoo.setTextColor(getResources().getColor(R.color.zoo_ferme));
			etatZoo.setTextSize(18);
			prochaineOuverture.setText(Constantes.PROCHAIN_HORAIRE+horaireZoo.getNextOpenning());	
		}
		
		/** Récupération des horaires dans la base de données. **/
		practicalInformationDao = DatabaseManager.getDao().getPracticalInformationDao();
		lespracticalInformationDao = practicalInformationDao.findAll();
		p = lespracticalInformationDao.get(0);
		
		closedAnnuel.setText(getResources().getString(R.string.period_close)+" du "+p.annual_closing+" au "+p.annual_opening+" inclus");
		
		/** 
		 * Au lancement du fragment afin de ne pas avoir un champs vide on se position directement sur l'été
		 * 
		 **/
			summer.setTextColor(getResources().getColor(R.color.a_la_une));
			summer.setTypeface(null, Typeface.BOLD);
			horaireSummer = p.summer_week_opening_time+"h - "+p.summer_week_closing_time+"h en semaine"+"\n"
			  +p.summer_weekend_opening_time+"h - "+p.summer_weekend_closing_time+"h le week end et jours fériés";
			contentSummerWinterHoraire.setText(horaireSummer);
			contentSummerWinterHoraire.setTypeface(null, Typeface.BOLD);
		

		/** Gestion des clics sur les bouton Eté ou Hiver **/
		summer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				summer.setTextColor(getResources().getColor(R.color.a_la_une));
				winter.setTextColor(getResources().getColor(R.color.Black));
				summer.setTypeface(null, Typeface.BOLD);
				winter.setTypeface(null, Typeface.NORMAL);
				contentSummerWinterHoraire.setTypeface(null, Typeface.BOLD);
				
				String text;
				text = p.summer_week_opening_time+"h - "+p.summer_week_closing_time+"h en semaine"+"\n"
					  +p.summer_weekend_opening_time+"h - "+p.summer_weekend_closing_time+"h le week end et jours fériés";
				contentSummerWinterHoraire.setText(text);
				
			}
		});
		
		winter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				winter.setTextColor(getResources().getColor(R.color.a_la_une));
				summer.setTextColor(getResources().getColor(R.color.Black));
				winter.setTypeface(null, Typeface.BOLD);
				summer.setTypeface(null, Typeface.NORMAL);
				String text;
				text = p.winter_week_opening_time+"h - "+p.winter_week_closing_time+"h en semaine"+"\n"
					  +p.winter_weekend_opening_time+"h - "+p.winter_weekend_closing_time+"h le week end et jours fériés";
				contentSummerWinterHoraire.setText(text);
				
			}
		});
		
		
		
		return myInflatedView;
	}
}
