package com.platine.zoodelille.adapter;

import java.text.DecimalFormat;
import java.util.List;

import com.platine.zoodelille.R;
import com.platine.zoodelille.beans.Animal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class AnimalAdapter extends BaseAdapter {

    List<Animal> animalList;
    LayoutInflater inflater;
    Context ctx;

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
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_view_animal,
                    null);

            holder.animalName = (TextView) convertView
                    .findViewById(R.id.animalName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        Log.v("AnimalName",animalList.get(position).getName());
        
        holder.animalName.setText(animalList.get(position).getName());
        return convertView;
    }
}