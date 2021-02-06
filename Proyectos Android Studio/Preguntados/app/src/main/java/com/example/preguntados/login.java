package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class login extends AppCompatActivity {

    Button btnRegistrar;
    Button btnIngresar;
    Button btnjugarf;
    TextView lbjugador1, lbjugador2;
    EditText txtusuario,txtcontra;
    boolean pantalla;
    Carchivos  objarchivo;
    int global;
    ArrayList<Cuenta> listCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        conectar();
        Bundle boton = getIntent().getExtras();
        global =0;


        objarchivo = new Carchivos(getApplicationContext());
        listCuenta = objarchivo.listUsuarios();
        pantalla = boton.getBoolean("boton");
        if(pantalla == true){


            btnIngresar.setVisibility(View.INVISIBLE);
            btnRegistrar.setVisibility(View.VISIBLE);
            btnjugarf.setVisibility(View.INVISIBLE);
            lbjugador2.setVisibility(View.INVISIBLE);
            lbjugador1.setVisibility(View.INVISIBLE);


        }else if(pantalla == false){


            btnRegistrar.setVisibility(View.INVISIBLE);
            btnIngresar.setVisibility(View.VISIBLE);
            btnjugarf.setVisibility(View.VISIBLE);
            lbjugador2.setVisibility(View.VISIBLE);
            lbjugador1.setVisibility(View.VISIBLE);
            btnjugarf.setEnabled(true);
        }

        btnjugarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !lbjugador1.getText().equals("") && !lbjugador2.getText().equals("")){

                    Intent intent = new Intent(getApplicationContext(),login2.class);

                    startActivity(intent);


                }
                else{

                    Toast.makeText(getApplicationContext(),"INGRESE LOS JUGADORES PARA CONTINUAR",Toast.LENGTH_LONG).show();


                }


               // Intent intent = new Intent(getApplicationContext(), tablero.class);
               // boolean registrar = true;
               // intent.putExtra("boton", registrar);

              //  startActivity(intent);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    objarchivo.escribir(txtusuario.getText().toString());
                    objarchivo.escribir(txtcontra.getText().toString());
                    txtusuario.setText("");
                    txtcontra.setText("");
                    Toast.makeText(getApplicationContext(),"JUGADOR REGISTRADO CORRECTAMENTE",Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean funciono= false;
                String jugador = "";

                for (Cuenta u: listCuenta) {



                    if (u.Usuario.equals(txtusuario.getText().toString().trim()) && u.Contraseña.equals(txtcontra.getText().toString().trim())) {


                        funciono = true;
                        jugador= u.Usuario;

                    }

                }
                if(funciono == false){


                    Toast.makeText(getApplicationContext(),"NO EXISTE EL USUARIO INGRESADO",Toast.LENGTH_LONG).show();

                }
                if(funciono == true){

                    global++;
                    txtusuario.setText("");
                    txtcontra.setText("");

                    if(global==1){
                        lbjugador1.setText("Jugador 1 => " + jugador );

                    }else if(global == 2){
                        txtusuario.setText("");
                        txtcontra.setText("");
                        lbjugador2.setText("Jugador 2 => " + jugador );

                    }



                }

            }
        });


    }

    private void conectar() {
        btnIngresar= findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnjugarf = findViewById(R.id.btnJugarf);
        lbjugador1 = findViewById(R.id.lbljugador1);
        lbjugador2 = findViewById(R.id.lbljugador2);
        txtusuario = findViewById(R.id.txtUsuario);
        txtcontra = findViewById(R.id.txtContra);
    }



}
