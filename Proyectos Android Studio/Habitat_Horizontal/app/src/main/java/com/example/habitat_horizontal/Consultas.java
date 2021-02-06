package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Consultas extends AppCompatActivity {

    Button btnConsultar, btnFecha;
    TextView lbMostrar, lbfechas;
    Spinner spConsulta,spDia,spMes, spAnio;
    ArrayList<String> listConsultas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        conectar();
        spinnerConsultas();

        lbfechas.setVisibility(View.INVISIBLE);
        spDia.setVisibility(View.INVISIBLE);
        spMes.setVisibility(View.INVISIBLE);
        spAnio.setVisibility(View.INVISIBLE);
        btnFecha.setVisibility(View.INVISIBLE);

        String [] SpDia ={"DIA","01","02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22", "23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpDia);
        spDia.setAdapter(Adapter1);

        String [] SpMes ={"MES","01","02", "03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> Adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpMes);
        spMes.setAdapter(Adapter2);

        String [] Spanio ={"ANIO","2018","2019","2020", "2021","2022"};
        ArrayAdapter<String> Adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Spanio);
        spAnio.setAdapter(Adapter3);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemSeleccionado();
            }
        });
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FechaD = spDia.getSelectedItem().toString()+"/"+spMes.getSelectedItem().toString()+"/"+spAnio.getSelectedItem().toString();
                lbMostrar.setText("Unidades arrendadas el" + FechaD + ": "+ String.valueOf(UnidadesADia(FechaD)));
                lbfechas.setVisibility(View.INVISIBLE);
                spDia.setVisibility(View.INVISIBLE);
                spMes.setVisibility(View.INVISIBLE);
                spAnio.setVisibility(View.INVISIBLE);
                btnFecha.setVisibility(View.INVISIBLE);
                btnConsultar.setEnabled(true);
            }
        });


    }

    private void conectar() {
        spDia = findViewById(R.id.SpinnerDiaC);
        spMes = findViewById(R.id.SpinnerMesC);
        spAnio = findViewById(R.id.SpinnerAnioC);
        spConsulta = findViewById(R.id.SpinnerConsulta);
        btnConsultar = findViewById(R.id.btnConsultarC);
        btnFecha = findViewById(R.id.btnBFechaC);
        lbMostrar = findViewById(R.id.lbMostrar);
        lbfechas = findViewById(R.id.lbfechas);
    }


    private void spinnerConsultas(){
        listConsultas.add(" ");
        listConsultas.add("# Unidades recibidas por la empresa");
        listConsultas.add("# Unidades Arrendadas");
        listConsultas.add("# Unidades Disponibles");
        listConsultas.add("Mejor cliente");
        listConsultas.add("Valor Promedio arriendos");
        listConsultas.add("Unidades arrendadas en un día");
        listConsultas.add("Tipo de vivienda más común");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listConsultas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spConsulta.setAdapter(adapter);

    }

    private void ItemSeleccionado(){

        int sp = spConsulta.getSelectedItemPosition();

        switch (sp){

            case 1:
                Toast.makeText(getApplicationContext(), spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+UnidadesH() + " ");
                break;
            case 2:
                Toast.makeText(getApplicationContext(),   spConsulta.getSelectedItem().toString() , Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+UnidadesA() + " ");
                break;
            case 3:
                Toast.makeText(getApplicationContext(),  spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+UnidadesD() + " ");
                break;
            case 4:
                Toast.makeText(getApplicationContext(),  spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+MejorC());
                break;
            case 5:
                Toast.makeText(getApplicationContext(),  spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+ValorP() + " ");
                break;
            case 6:
                Toast.makeText(getApplicationContext(),  spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbfechas.setVisibility(View.VISIBLE);
                spDia.setVisibility(View.VISIBLE);
                spMes.setVisibility(View.VISIBLE);
                spAnio.setVisibility(View.VISIBLE);
                btnFecha.setVisibility(View.VISIBLE);
                btnConsultar.setEnabled(false);
                // lbMostrar.setText(UnidadesADia(txtFecha.toString()));
                break;
            case 7:
                Toast.makeText(getApplicationContext(),  spConsulta.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                lbMostrar.setText(spConsulta.getSelectedItem().toString()+ ": "+ViviendaC());
                break;
        }

    }

    //1.Numero de unidades habitacionales recibidas por la empresa
    private int UnidadesH(){
        int i= 0;
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(*) from UnidadesH";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                i = c.getInt(0);
            }while (c.moveToNext());
        }
        db.close();
        return i;

    }

    //2.Numero de unidades arrendadas
    private int UnidadesA(){
        int i= 0;
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(Arrendado)from UnidadesH where Arrendado == 'si' ";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                i = c.getInt(0);
            }while (c.moveToNext());
        }
        db.close();
        return i;

    }
    //3.Numero de unidades disponibles (estan para arrendar)
    private int UnidadesD(){
        int i= 0;
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(  )from UnidadesH where Arrendado == 'no' ";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                i = c.getInt(0);
            }while (c.moveToNext());
        }
        db.close();
        return i;

    }

    //4. Mejor cliente
    private String MejorC(){
        String cliente= "";
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select NombreP, MAX (cont) from (select NombreP, COUNT(*) cont from UnidadesH group by NombreP)";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                cliente = c.getString(0);
            }while (c.moveToNext());
        }
        db.close();
        return cliente;

    }

    //5.Valor promedio de los arriendos
    private int ValorP(){
        int i= 0;
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select avg(Precio) from UnidadesH ";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                i = c.getInt(0);
            }while (c.moveToNext());
        }
        db.close();
        return i;

    }

    //6.Unidades arrendadas en un dia especifico
    private int UnidadesADia(String dia){
        int i= 0;
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(*) from UnidadesH where Fecha_Arrendado = '" + dia + "' ";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){
            do{
                i = c.getInt(0);
            }while (c.moveToNext());
        }
        db.close();
        return i;
    }

    //7.Tipo de vivienda mas comun
    private String ViviendaC(){
        String vivienda= "";
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select Tipo, MAX (cont) from (select Tipo, COUNT(Tipo) cont from UnidadesH group by Tipo) ";
        Cursor c = db.rawQuery(SQL, null);
        if(c.moveToFirst()){

            do{
                vivienda = c.getString(0);
            }while (c.moveToNext());
        }
        db.close();
        return vivienda;

    }





}
