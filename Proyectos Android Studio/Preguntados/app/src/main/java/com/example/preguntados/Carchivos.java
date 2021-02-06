package com.example.preguntados;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Carchivos {

    String archivoC = "Cuentas.txt";
    String archivoP ="Preguntas.txt";
    String archivoPunt = "Puntaje.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public Carchivos(Context ctx){

        this.ctx = ctx;
    }

    public void escribir(String textarchivo) throws IOException {

        try {
            fos = ctx.openFileOutput(archivoC, Context.MODE_APPEND);
            fos.write(textarchivo.getBytes());
            fos.write('\n');
            fos.close();
        }
        catch (FileNotFoundException e)
        {

            Log.e("", e.getMessage());

        }
        catch (IOException ex)
        {

            Log.e(" ",ex.getMessage());
        }





    }

    public void escribirPuntajes(String textarchivo) throws IOException {

        try {
            fos = ctx.openFileOutput(archivoPunt, Context.MODE_APPEND);
            fos.write(textarchivo.getBytes());
            fos.write('\n');
            fos.close();
        }
        catch (FileNotFoundException e)
        {

            Log.e("", e.getMessage());

        }
        catch (IOException ex)
        {

            Log.e(" ",ex.getMessage());
        }





    }


    public ArrayList<Pregunta> listpregunta(){
        ArrayList<Pregunta> listp = new ArrayList<>();

        int i = 1;
        int cont = 0;
        String lectura= "",preguntas = "", opA = "", opB = "", opC="", opD="", correcta="",puntos="";
        char caracter;

        try {
            fis = ctx.openFileInput(archivoP);
            while (i > 0) {

                i = fis.read();
                caracter = (char) i;
                lectura += caracter;
                if (i == '\n') {

                    switch (cont) {

                        case 0:
                            preguntas = lectura.trim();
                            break;

                        case 1:
                            opA = lectura.trim();
                            break;
                        case 2:
                            opB = lectura.trim();
                            break;
                        case 3:
                            opC= lectura.trim();
                            break;

                        case 4:
                            opD = lectura.trim();
                            break;

                        case 5:
                            correcta = lectura.trim();
                            break;
                        case 6:
                            puntos = lectura.trim();
                            cont = -1;
                            listp.add(new Pregunta(preguntas, opA,opB,opC,opD,correcta,puntos));
                            break;
                    }
                    lectura = "";
                    cont ++;

                }


            }
        } catch (Exception e) {

            Log.e("", e.getMessage());

        }

        return listp;
    }

    public ArrayList<Cuenta> listUsuarios(){
        ArrayList<Cuenta> listIniciar = new ArrayList<>();

        int i = 1;
        int cont = 0;
        String Usuario = "", Contrase = "", lectura = "";
        char caracter;

        try {
            fis = ctx.openFileInput(archivoC);
            while (i > 0) {

                i = fis.read();
                caracter = (char) i;
                lectura += caracter;
                if (i == '\n') {

                    switch (cont) {

                        case 0:
                            Usuario = lectura.trim();
                            break;
                        case 1:
                            Contrase = lectura.trim();
                            cont = -1;
                            listIniciar.add(new Cuenta(Usuario, Contrase));
                            break;
                    }
                    lectura = "";
                    cont ++;

                }


            }
        } catch (Exception e) {

            Log.e("", e.getMessage());

        }

        return listIniciar;
    }


    public ArrayList<String> listpp(){
        ArrayList<String> listpunt = new ArrayList<>();

        int i = 1;
        int cont = 0;
        String Usuario = "", puntoo = "", lectura = "";
        char caracter;

        try {
            fis = ctx.openFileInput(archivoPunt);
            while (i > 0) {

                i = fis.read();
                caracter = (char) i;
                lectura += caracter;
                if (i == '\n') {

                    switch (cont) {

                        case 0:
                            Usuario = lectura.trim();

                            break;
                        case 1:
                            puntoo = lectura.trim();
                            cont = -1;
                            Usuario += puntoo;
                            listpunt.add(Usuario);
                            lectura = "";
                            break;
                    }
                    lectura = "";
                    cont ++;

                }


            }
        } catch (Exception e) {

            Log.e("", e.getMessage());

        }

        return listpunt;
    }


}




