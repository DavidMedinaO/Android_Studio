package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnjugar;
    Button btnRegistrar;
    Button btnpuntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), login.class);
                boolean registrar = true;
                intent.putExtra("boton", registrar);

                startActivity(intent);


            }
        });

       btnjugar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), login.class);
               boolean registrar = false;
               intent.putExtra("boton", registrar);

               startActivity(intent);


           }
       });



    }

    private void conectar() {

        btnRegistrar = findViewById(R.id.btnRegistrarse);
        btnjugar = findViewById(R.id.btnJugar);
        btnpuntajes = findViewById(R.id.btnPuntajes);

    }
}
