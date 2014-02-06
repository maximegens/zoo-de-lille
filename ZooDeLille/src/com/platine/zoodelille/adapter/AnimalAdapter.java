package com.platine.zoodelille.adapter;

import java.text.DecimalFormat;
import java.util.List;

import com.platine.zoodelille.R;
import com.platine.zoodelille.bdd.DatabaseManager;
import com.platine.zoodelille.beans.Animal;
import com.platine.zoodelille.dao.AnimalDao;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AnimalAdapter extends BaseAdapter {

    List<Animal> animalList;
    LayoutInflater inflater;
    Context ctx;
	private AnimalDao animalDao;
	private int resID;

    public AnimalAdapter(Context context,List<Animal> animalList) {
        inflater = LayoutInflater.from(context);
        this.animalList = animalList;
        ctx=context;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {

        return animalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView animalName;
        ImageView animalPicture;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_affichage_animal,
                    null);

            holder.animalName = (TextView) convertView
                    .findViewById(R.id.animal_Name);
            holder.animalPicture = (ImageView)convertView
                    .findViewById(R.id.animal_picture);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        Log.v("AnimalName",animalList.get(position).getName());
        
        
        holder.animalName.setText(animalList.get(position).getName());
        
        animalDao = DatabaseManager.getDao().getAnimalDao();		
		Animal a = animalDao.findById(position+1);
        
		String picture = a.getPicture_location();
		String[] tab_picture = picture.split(",");
		if(tab_picture.length>0){
			resID = ctx.getResources().getIdentifier(tab_picture[0], "drawable", convertView.getContext().getPackageName());;
		}
		else{
			resID = R.drawable.no_image;
		}
		holder.animalPicture.setImageResource(resID);

        return convertView;
    }
}