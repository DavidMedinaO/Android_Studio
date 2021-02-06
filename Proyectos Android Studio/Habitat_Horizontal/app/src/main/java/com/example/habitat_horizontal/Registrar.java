package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.StringBufferInputStream;

public class Registrar extends AppCompatActivity {
    Button btnRegistrar;
    EditText txtPrecio, txtDireccion, txtNombreP,txtTelefono;
    Spinner spTipo,spDia,spMes,spAnio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        conectar();

        String [] SpTipo ={"Casa","Apartamento", "Finca"};
        ArrayAdapter<String> Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpTipo);
        spTipo.setAdapter(Adapter);

        String [] SpDia ={"DIA","01","02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22", "23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpDia);
        spDia.setAdapter(Adapter1);

        String [] SpMes ={"MES","01","02", "03","04","05","06","07","08","09","10","11","12"};
        ArrayAdapter<String> Adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,SpMes);
        spMes.setAdapter(Adapter2);

        String [] Spanio ={"ANIO","2018","2019","2020", "2021","2022"};
        ArrayAdapter<String> Adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Spanio);
        spAnio.setAdapter(Adapter3);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!spDia.getSelectedItem().toString().equals("DIA")  && !spMes.getSelectedItem().toString().equals("MES") && !spAnio.getSelectedItem().toString().equals("ANIO")){

                    String FechaR = spDia.getSelectedItem().toString()+"/"+spMes.getSelectedItem().toString()+"/"+spAnio.getSelectedItem().toString();
                    Guardar(spTipo.getSelectedItem().toString(),txtPrecio.getText().toString(),txtDireccion.getText().toString(),txtNombreP.getText().toString(),txtTelefono.getText().toString(),FechaR);
                    Toast.makeText(Registrar.this, "Registrado correctamente",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(Registrar.this, "No se ha ingresado la fecha",Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    private void conectar() {
        txtPrecio = findViewById(R.id.txtPrecio);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtNombreP = findViewById(R.id.txtNombreP);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        spTipo = findViewById(R.id.SpinnerTipo);
        spDia = findViewById(R.id.SpinnerDia);
        spMes = findViewById(R.id.SpinnerMes);
        spAnio = findViewById(R.id.SpinnerAnio);
    }

    private void Guardar (String Tipo, String Precio, String Direccion,String NombreP, String Telefono,String Fecha_Recepcion){

        DbHelper helper = new DbHelper(this,"BD",null,1);
        SQLiteDatabase db= helper.getWritableDatabase();

        try{

            ContentValues cv = new ContentValues();
            String Farrendado = "00/00/0000";
            String Arrendado = "no";
            cv.put("Tipo", Tipo);
            cv.put("Precio", Precio);
            cv.put("Direccion", Direccion);
            cv.put("NombreP", NombreP);
            cv.put("Telefono", Telefono);
            cv.put("Fecha_Recepcion", Fecha_Recepcion);
            cv.put("Fecha_Arrendado",Farrendado);
            cv.put("Arrendado", Arrendado);
            db.insert("UnidadesH",null,cv);
            db.close();
            Toast.makeText(this, "Registrado Correctamente",Toast.LENGTH_LONG).show();
            Intent I = new Intent(getApplicationContext(), BienesRaices.class);
            startActivity(I);

        }catch(Exception ex)
        {

            Toast.makeText(this,"Error"+ex.getMessage(), Toast.LENGTH_LONG).show();

        }




    }

}
