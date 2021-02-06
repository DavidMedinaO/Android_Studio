package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBienes, btnConsultas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnBienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), BienesRaices.class);
                startActivity(I);

            }
        });
        btnConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), Consultas.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnBienes = findViewById(R.id.btnAdmin);
        btnConsultas = findViewById(R.id.btnConsultas);
    }
}
