package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Arrendar extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> listEntidad;
    int UnidC=0,UnidA=0, UnidF=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrendar);

        lvItems = findViewById(R.id.lvItems);
        listEntidad = GetArrayItems();
        adaptador = new Adaptador(this,GetArrayItems());
        lvItems.setAdapter(adaptador);


    }

    private ArrayList<Entidad> GetArrayItems(){

        ArrayList<Entidad> listItems = new ArrayList<>();

        //listItems.add(new Entidad(R.drawable.libro,"hola","DISPONIBLE"));

        listItems = ListHabit();
        return listItems;
    }

    private ArrayList<Entidad>  ListHabit(){

        ArrayList<Entidad> listItem = new ArrayList<>();
        DbHelper helper = new DbHelper(this,"BD",null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select Id , Tipo,Precio,Direccion,NombreP,Telefono, Fecha_Recepcion ,Fecha_Arrendado, Arrendado from UnidadesH";
        //String SQL = "Select * from Contactos";
        Cursor c = db.rawQuery(SQL,null);

        if(c.moveToFirst()){

            do{
                String linea = "Tipo: " + c.getString(1) + "\n" + "Precio: "+c.getString(2) + "\n" + "Direccion: " + c.getString(3) + "\n" + "Propetario: " + c.getString(4)  + "\n" + "Cedula: " + c.getString(0)+ "\n" + "Telefono: " + c.getString(5)+ "\n" + "Fecha Recepcion: " + c.getString(6);
                String disponible = c.getString(8);

                if(disponible.equals("si")){

                    if(c.getString(1).equals("Casa")){
                        if(UnidC == 0){
                            listItem.add(new Entidad(R.drawable.casa1,linea,"ARRENDADO"));
                            UnidC++;
                        }else if(UnidC == 1){
                            listItem.add(new Entidad(R.drawable.casa2,linea,"ARRENDADO"));
                            UnidC++;
                        }else{
                            listItem.add(new Entidad(R.drawable.casa3,linea,"ARRENDADO"));
                            UnidC=0;

                        }
                    }

                    if(c.getString(1).equals("Apartamento")){
                        if(UnidA == 0){
                            listItem.add(new Entidad(R.drawable.apto1,linea,"ARRENDADO"));
                            UnidA++;
                        }else if(UnidA == 1){
                            listItem.add(new Entidad(R.drawable.apto2,linea,"ARRENDADO"));
                            UnidA++;
                        }else{
                            listItem.add(new Entidad(R.drawable.apto3,linea,"ARRENDADO"));
                            UnidA=0;

                        }
                    }

                    if(c.getString(1).equals("Finca")){
                        if(UnidF == 0){
                            listItem.add(new Entidad(R.drawable.finca1,linea,"ARRENDADO"));
                            UnidF++;
                        }else if(UnidF == 1){
                            listItem.add(new Entidad(R.drawable.finca2,linea,"ARRENDADO"));
                            UnidF++;
                        }else{
                            listItem.add(new Entidad(R.drawable.finca3,linea,"ARRENDADO"));
                            UnidF=0;

                        }
                    }


                }else{

                    if(c.getString(1).equals("Casa")){
                        if(UnidC == 0){
                            listItem.add(new Entidad(R.drawable.casa1,linea,"DISPONIBLE"));
                            UnidC++;
                        }else if(UnidC == 1){
                            listItem.add(new Entidad(R.drawable.casa2,linea,"DISPONIBLE"));
                            UnidC++;
                        }else{
                            listItem.add(new Entidad(R.drawable.casa3,linea,"DISPONIBLE"));
                            UnidC=0;

                        }
                    }

                    if(c.getString(1).equals("Apartamento")){
                        if(UnidA == 0){
                            listItem.add(new Entidad(R.drawable.apto1,linea,"DISPONIBLE"));
                            UnidA++;
                        }else if(UnidA == 1){
                            listItem.add(new Entidad(R.drawable.apto2,linea,"DISPONIBLE"));
                            UnidA++;
                        }else{
                            listItem.add(new Entidad(R.drawable.apto3,linea,"DISPONIBLE"));
                            UnidA=0;

                        }
                    }

                    if(c.getString(1).equals("Finca")){
                        if(UnidF == 0){
                            listItem.add(new Entidad(R.drawable.finca1,linea,"DISPONIBLE"));
                            UnidF++;
                        }else if(UnidF == 1){
                            listItem.add(new Entidad(R.drawable.finca2,linea,"DISPONIBLE"));
                            UnidF++;
                        }else{
                            listItem.add(new Entidad(R.drawable.finca3,linea,"DISPONIBLE"));
                            UnidF=0;

                        }
                    }
                }

            }while (c.moveToNext());

        }

        db.close();
        return listItem;
    }
}
