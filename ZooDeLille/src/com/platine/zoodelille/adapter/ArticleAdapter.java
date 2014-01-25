package com.platine.zoodelille.adapter;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.platine.zoodelille.R;
import com.platine.zoodelille.beans.Article;

/**
 * Adaptateur permettant de mettre en forme et d'afficher chaque item, dans un style personnalisÃ©, de la listeView pour la page d'accueil.
 * @author Maxime
 *
 */
public class ArticleAdapter extends BaseAdapter {

	List<Article> lesarticles = new ArrayList<Article>();
	Context ctx;
	LayoutInflater inflater;

	public ArticleAdapter(Context context,List<Article> lesarticles) {
		inflater = LayoutInflater.from(context);
		this.lesarticles = lesarticles;
		ctx = context;
		
	}
	@Override
	public int getCount() {
		return lesarticles.size();
	}

	@Override
	public Object getItem(int position) {
	
		return lesarticles.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	private class ViewHolder {
		ImageView img;
		TextView articleId;
		TextView articleTitre;
		TextView articleSummary;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_list_view_article, null);

			holder.img = (ImageView)convertView.findViewById(R.id.img_article_list_view);
			holder.articleId = (TextView)convertView.findViewById(R.id.id_article_list_view);
			holder.articleTitre = (TextView)convertView.findViewById(R.id.titre_article_list_view);
			holder.articleSummary = (TextView)convertView.findViewById(R.id.summary_article__list_view);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		String lien = lesarticles.get(position).getLien_image();
		if(lien != null){
			int resID = ctx.getResources().getIdentifier(lien, "drawable", ctx.getPackageName());
			holder.img.setImageResource(resID);
		}else
			holder.img.setImageResource(R.drawable.no_image);
		holder.articleId.setText(String.valueOf(lesarticles.get(position).getId()));
		holder.articleTitre.setText(lesarticles.get(position).getTitle());
		holder.articleSummary.setText(lesarticles.get(position).getSummary());
		return convertView;
	}
}
