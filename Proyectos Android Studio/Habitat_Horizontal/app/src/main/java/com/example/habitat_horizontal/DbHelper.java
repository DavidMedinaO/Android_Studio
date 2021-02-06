package com.example.habitat_horizontal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    String Tabla = "create Table UnidadesH (Id Integer primary key autoincrement, Tipo Text, Precio Text,Direccion Text, NombreP Text, Telefono Text, Fecha_Recepcion Text,Fecha_Arrendado Text, Arrendado bit)";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tabla);
    }
}
