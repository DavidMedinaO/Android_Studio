package com.example.habitat_horizontal;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Entidad> listItems;

    public Adaptador(Context context,ArrayList<Entidad> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Entidad Item = (Entidad) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        //ImageView imgFoto= convertView.findViewById(R.id.imgFoto);
        Button imgFoto= convertView.findViewById(R.id.imgFoto);
        TextView tvContenido = convertView.findViewById(R.id.tvcontenido);
        TextView tvdisponible = convertView.findViewById(R.id.tvDisponible);

        //imgFoto.setImageResource(Item.getImgFoto());
        imgFoto.setBackgroundResource(Item.getImgFoto());
        tvContenido.setText(Item.getContenido());
        tvdisponible.setText(Item.getDisponibilidad());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(context, ArrendarFinal.class);
                    intent.putExtra("ObjetoE",Item);
                    context.startActivity(intent);


            }
        });


        return convertView;
    }
}
