package com.platine.zoodelille.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context ctx;
    int imageBackground;
    private Integer[] tableau;
  
    public ImageAdapter(Context c, Integer[] tableau) {
        ctx = c;
        this.tableau = tableau;
    }

    @Override
    public int getCount() {
      
        return tableau.length;
    }

    @Override
    public Object getItem(int arg0) {
      
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
      
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ImageView iv = new ImageView(ctx);
        iv.setImageResource(tableau[arg0]);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.setLayoutParams(new Gallery.LayoutParams(600,480));
        iv.setBackgroundResource(imageBackground);
        return iv;
    }

}


