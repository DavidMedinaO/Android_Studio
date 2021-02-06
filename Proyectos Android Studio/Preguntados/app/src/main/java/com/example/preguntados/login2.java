package com.example.preguntados;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class login2 extends AppCompatActivity {

    TextView lblj1;
    TextView lblj2;
    TextView lblpj1;
    TextView lblpj2;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;
    Button btn16;
    Button btn17;
    Button btn18;
    Button btn19;
    Button btn20;

    TextView tbPregunta;
    RadioGroup rgPreguntas;
    RadioButton rbopA,rbopB,rbopC,rbopD;

    Button btnEnviar;
    int turno = 0;
    int contadorg;
    int posi;
    Carchivos objarchivo;
    ArrayList<Pregunta> listp;
    ArrayList<Button> listButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        objarchivo = new Carchivos(getApplicationContext());
        conectar();
        //turno=0;
        contadorg = 0;
        listButton = new ArrayList<>();
        conectarButton();
        btnEnviar.setEnabled(false);

        listp= objarchivo.listpregunta();


        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                contadorg++;

                posi = boton(listp);
                btnEnviar.setEnabled(true);

                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,0);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);


                    }
                });



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,1);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,2);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,3);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,4);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                int posp = boton(listp);
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,5);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,6);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,7);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,8);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,9);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,10);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validar(listp,posi,listButton,11);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,12);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,13);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,14);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,15);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,16);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validar(listp,posi,listButton,17);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,18);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorg++;
                posi = boton(listp);
                btnEnviar.setEnabled(true);
                btnEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int puntos = validar(listp,posi,listButton,19);
                        btnEnviar.setEnabled(false);
                        blanco();
                        terminarjuego(contadorg);
                    }
                });
            }
        });







    }

    private void conectar() {

        lblj1 = findViewById(R.id.tbjugador1);
        lblj2 = findViewById(R.id.tbjugador2);
        lblpj1 = findViewById(R.id.tbpuntos1);
        lblpj2 = findViewById(R.id.tbpuntos2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);
        btn16 = findViewById(R.id.btn16);
        btn17 = findViewById(R.id.btn17);
        btn18= findViewById(R.id.btn18);
        btn19= findViewById(R.id.btn19);
        btn20 = findViewById(R.id.btn20);


        tbPregunta = findViewById(R.id.tbPregunta);
        rgPreguntas = findViewById(R.id.rgTipoP);
        rbopA = findViewById(R.id.rbopA);
        rbopB =  findViewById(R.id.rbopB);
        rbopC = findViewById(R.id.rbopC);
        rbopD = findViewById(R.id.rbopD);

        btnEnviar = findViewById(R.id.btnValidar);



    }

    public int boton (ArrayList<Pregunta> listp2){

        Random r = new Random();

        int aleatorio = r.nextInt(listp2.size()-1);

        tbPregunta.setText(listp2.get(aleatorio).getPregun());
        rbopA.setText(listp2.get(aleatorio).getOpA());
        rbopB.setText(listp2.get(aleatorio).getOpB());
        rbopC.setText(listp2.get(aleatorio).getOpC());
        rbopD.setText(listp2.get(aleatorio).getOpD());
        return aleatorio;
    }



    public int  validar(ArrayList<Pregunta> listp2, int pos, ArrayList<Button> listb , int boton){

        String respuesta = "";
        int valor=0;
        int bevalor =0;
        if(rgPreguntas.getCheckedRadioButtonId() == R.id.rbopA){


            respuesta= rbopA.getText().toString();



        }else if(rgPreguntas.getCheckedRadioButtonId() == R.id.rbopB){



            respuesta =  rbopB.getText().toString();
        }else if(rgPreguntas.getCheckedRadioButtonId() == R.id.rbopC){


            respuesta= rbopC.getText().toString();


        }else if(rgPreguntas.getCheckedRadioButtonId() == R.id.rbopD){


            respuesta= rbopD.getText().toString();

        }

        //String correcta = listp2.get(pos).getOpCorrecta();

        if(respuesta.equals(listp2.get(pos).getOpCorrecta())){


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                listb.get(boton).setBackground(getDrawable(R.drawable.btnverde));
            }


            if(turno==0) {
                valor = Integer.parseInt(listp2.get(pos).getPuntos().trim());
                bevalor = Integer.parseInt(lblpj1.getText().toString());

                bevalor = bevalor + valor;

                lblpj1.setText(String.valueOf(bevalor));
                turno++;

            }
            if(turno==1){

               valor = Integer.parseInt(listp2.get(pos).getPuntos());
                bevalor = Integer.parseInt(lblpj2.getText().toString());

                bevalor = bevalor + valor;

                lblpj2.setText(String.valueOf(bevalor));
                turno= 0;

            }


        }else {



            if (turno==0) {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    listb.get(boton).setBackground(getDrawable(R.drawable.btnrojo));
                }
                valor = 0;
                turno++;

            }else if (turno==1){

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    listb.get(boton).setBackground(getDrawable(R.drawable.btnrojo));
                }
                valor = 0;
                turno=0;

            }
        }
        return 2;


    }

    public void blanco(){


        tbPregunta.setText("");
        rbopA.setText("");
        rbopB.setText("");
        rbopC.setText("");
        rbopD.setText("");
    }


    public void terminarjuego(int cont){

        if(cont > 19){

            try {
                objarchivo.escribirPuntajes(lblj1.getText().toString());
                objarchivo.escribirPuntajes(lblpj1.getText().toString());
                objarchivo.escribirPuntajes(lblj2.getText().toString());
                objarchivo.escribirPuntajes(lblpj2.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(), Puntoss.class);

            startActivity(intent);
            Toast.makeText(getApplicationContext(),"JUEGO TERMINADOS",Toast.LENGTH_LONG).show();



        }


    }

    public void conectarButton(){


        listButton.add(btn1);
        listButton.add(btn2);
        listButton.add(btn3);
        listButton.add(btn4);
        listButton.add(btn5);
        listButton.add(btn6);
        listButton.add(btn7);
        listButton.add(btn8);
        listButton.add(btn9);
        listButton.add(btn10);
        listButton.add(btn11);
        listButton.add(btn12);
        listButton.add(btn13);
        listButton.add(btn14);
        listButton.add(btn15);
        listButton.add(btn16);
        listButton.add(btn17);
        listButton.add(btn18);
        listButton.add(btn19);
        listButton.add(btn20);
    }


}