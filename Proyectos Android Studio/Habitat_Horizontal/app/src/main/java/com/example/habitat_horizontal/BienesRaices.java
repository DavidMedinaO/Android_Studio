package com.example.habitat_horizontal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BienesRaices extends AppCompatActivity {

    Button btnArrendar, btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienes_raices);
        conectar();
        btnArrendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), Arrendar.class);
                startActivity(I);

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(),Registrar.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnArrendar = findViewById(R.id.btnArrendarB);
        btnRegistrar =  findViewById(R.id.btnRegsitrarB);
    }
}
