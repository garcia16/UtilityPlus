package com.example.utilityplus;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper{

    public DbHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override //Metodo para crear una tabla
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notas(Codigo integer (100) primary key, Titulo varchar(45) not null, Contenido varchar(300) not null,Fecha varchar(20)  not null)");
    }

    @Override //Metodo en caso de querer actualizar una nota
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists notas");
        db.execSQL("create table notas(Codigo integer (100) primary key,Titulo varchar(45) not null, Contenido varchar(300) not null,Fecha varchar(20)  not null)");
    }
    //Metodo listar registro de la db
    public ArrayList<String> getAllRegistros()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from notas", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(1) +"\n "+"\n "+" "+
                    res.getString(2) + "\n "+"\n "+ res.getString(3) );
            res.moveToNext();}
        return array_list;
    }
    //Mismo metodo que el de arriba pero en este caso me muestra el codigo para saber que nota eliminar
    public ArrayList<String> getAllRegistrosEliminar()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from notas", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add("Codigo: "+res.getString(0) +"\n "+"\n "+" "+
                    res.getString(1) + "\n "+"\n "+ res.getString(2)+"\n "+ res.getString(3) );
            res.moveToNext();}
        return array_list;
    }
}
