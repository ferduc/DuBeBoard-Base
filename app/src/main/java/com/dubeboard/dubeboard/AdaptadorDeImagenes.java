package com.dubeboard.dubeboard;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PC on 29/12/2015.
 */
public class AdaptadorDeImagenes extends BaseAdapter {

    // Declare Variables
    Context context;
    String[] titulos;
    int[] imagenes;
    LayoutInflater inflater;

    public AdaptadorDeImagenes(Context context, String[] titulos, int[] imagenes) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }


    @Override
    public int getCount() {

        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.grid_item, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.nombre_grid1);
        imgImg = (ImageView) itemView.findViewById(R.id.imagen_grid1);

        // Capture position and set to the TextViews
        txtTitle.setText(titulos[position]);
        imgImg.setImageResource(imagenes[position]);

        return itemView;
    }

}

