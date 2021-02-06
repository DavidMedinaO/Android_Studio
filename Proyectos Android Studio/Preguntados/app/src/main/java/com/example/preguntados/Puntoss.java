package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Puntoss extends AppCompatActivity {

    EditText lblt;
    ListView listV;
    Carchivos obja;
    ArrayList<Puntos> listp;
    ArrayList<String> liste = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntoss);
    conectar();
        obja = new Carchivos(getApplicationContext());



        liste=obja.listpp();



        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,liste);
        listV.setAdapter(adapter);


    }

    private void conectar() {


    listV = findViewById(R.id.listvp);


    }
}
