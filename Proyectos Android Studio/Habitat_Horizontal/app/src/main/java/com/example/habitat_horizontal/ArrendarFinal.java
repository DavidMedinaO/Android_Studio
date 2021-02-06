package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ArrendarFinal extends AppCompatActivity {

    private Entidad Item;
    TextView lbTitulo;
    Button btnImagen, btnArrendar, btnEliminar;
    Spinner spTipo,spDia,spMes,spAnio;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrendar_final);
        conectar();
        Item = (Entidad) getIntent().getSerializableExtra("ObjetoE");
        if(Item.getDisponibilidad().equals("ARRENDADO")){

            btnArrendar.setText("DESARRENDAR");
            spDia.setEnabled(false);
            spMes.setEnabled(false);
            spAnio.setEnabled(false);

        }

        lbTitulo.setText(Item.getContenido().split("\n")[0].split(" ")[1]);
        btnImagen.setBackgroundResource(Item.getImgFoto());
        id=Integer.valueOf(Item.getContenido().split("\n")[4].split(" ")[1]);

        String [] SpDia ={"DIA","01","02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22", "23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpDia);
        spDia.setAdapter(Adapter1);

        String [] SpMes ={"MES","01","02", "03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> Adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpMes);
        spMes.setAdapter(Adapter2);

        String [] Spanio ={"ANIO","2018","2019","2020", "2021","2022"};
        ArrayAdapter<String> Adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Spanio);
        spAnio.setAdapter(Adapter3);

        btnArrendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Item.getDisponibilidad().equals("DISPONIBLE")){

                    if(!spDia.getSelectedItem().toString().equals("DIA")  && !spMes.getSelectedItem().toString().equals("MES") && !spAnio.getSelectedItem().toString().equals("ANIO")){

                        String Disponible = "si";
                        String Fecha = spDia.getSelectedItem().toString()+"/"+spMes.getSelectedItem().toString()+"/"+spAnio.getSelectedItem().toString();
                        Editar(id,Fecha,Disponible);
                        Toast.makeText(ArrendarFinal.this, "Arrendado Correctamente",Toast.LENGTH_LONG).show();
                        Intent I = new Intent(getApplicationContext(), BienesRaices.class);
                        startActivity(I);

                    }else{
                        Toast.makeText(ArrendarFinal.this, "No se ha ingresado la fecha",Toast.LENGTH_LONG).show();

                    }

                }

                if (Item.getDisponibilidad().equals("ARRENDADO")){

                    String Disponible = "no";
                    String Fecha ="00/00/00";
                    Editar(id,Fecha,Disponible);
                    Toast.makeText(ArrendarFinal.this, "Desarrendado Correctamente",Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(), BienesRaices.class);
                    startActivity(I);


                }


            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(id);
                Intent I = new Intent(getApplicationContext(), BienesRaices.class);
                startActivity(I);
            }
        });



    }

    private void conectar() {
        btnImagen = findViewById(R.id.btnImagen);
        btnArrendar = findViewById(R.id.btnArrendarA);
        btnEliminar = findViewById(R.id.btnEliminarA);
        lbTitulo= findViewById(R.id.lbTitulo);
        spDia = findViewById(R.id.SpinnerDiaA);
        spMes = findViewById(R.id.SpinnerMesA);
        spAnio = findViewById(R.id.SpinnerAnioA);
    }

    private void Editar(int Id, String fecha, String disponible){

        DbHelper helper = new DbHelper(this,"BD",null,1);
        SQLiteDatabase db= helper.getWritableDatabase();

        String SQL = "Update UnidadesH set Fecha_Arrendado = '"+ fecha +"', Arrendado = '"+disponible+"' Where Id= " + Id;


        db.execSQL(SQL);
        db.close();

    }

    private void Eliminar(int Id){

        DbHelper helper = new DbHelper(this,"BD",null,1);
        SQLiteDatabase db= helper.getWritableDatabase();

        String SQL = "delete from UnidadesH Where Id= " + Id;

        Toast.makeText(this, "Unidad Residencial Eliminada",Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();

    }

}
