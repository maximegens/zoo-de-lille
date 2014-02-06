package com.platine.zoodelille.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.activity.MainActivity;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Article;
import com.platine.zoodelille.dao.ArticleDao;

/**
 * Fragment appelé par AccueilFragment permettant d'afficher en détails un article sur le zoo.
 *
 */
public class AccueilFragmentAffichageArticle extends Fragment {
	
	TextView titreArticle;
	TextView summaryArticle;
	TextView contenuArticle;
	ImageView imgArticle;
	ImageButton partager;
	ArticleDao articleDao;
	int idArticle;
	String id_temp;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View myInflatedView = inflater.inflate(R.layout.fragment_accueil_affichage_article, container,false);
		
		id_temp = getArguments().getString("id");
		idArticle = Integer.parseInt(id_temp);
		
		titreArticle = (TextView) myInflatedView.findViewById(R.id.titre_article);
		summaryArticle = (TextView) myInflatedView.findViewById(R.id.summary_article);
		contenuArticle = (TextView) myInflatedView.findViewById(R.id.contenu_article);
		imgArticle = (ImageView) myInflatedView.findViewById(R.id.img_article);
		partager = (ImageButton) myInflatedView.findViewById(R.id.partage_facebook);
		
		articleDao = DatabaseManager.getDao().getArticleDao();		
		Article a = articleDao.findById(idArticle);
		
		// Modification des TextView pour leur affecter les valeurs de l'article de la base de données.
		titreArticle.setText(a.getTitle());
		summaryArticle.setText(a.getSummary());
		contenuArticle.setText(a.getContent());
		if(a.getLien_image() != null){
			int resID = getResources().getIdentifier(a.getLien_image(), "drawable", myInflatedView.getContext().getPackageName());
			imgArticle.setImageResource(resID);
		}else
			imgArticle.setImageResource(R.drawable.no_image);

		partager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Intent MessIntent = new Intent(Intent.ACTION_SEND);
	        	MessIntent.setType("text/plain");
	        	MessIntent.putExtra(Intent.EXTRA_TEXT, titreArticle.getText().toString()+"\n\n"+contenuArticle.getText().toString());
	        	getActivity().startActivity(Intent.createChooser(MessIntent, "Partager avec..."));
			}
		});
		
		return myInflatedView;
	}
	
	/**
	 * Methode de sauvegarder des paramétres.
	 */
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	outState.putString("id", id_temp );
    	outState.putString("categorieFragmentSave", MainActivity.categorieFragmentSave);
        super.onSaveInstanceState(outState);
      }
}