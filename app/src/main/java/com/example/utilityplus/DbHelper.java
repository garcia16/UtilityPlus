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

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notas(Titulo varchar(45) primary key, Contenido varchar(300) not null,Fecha varchar(20)  not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists notas");
        db.execSQL("create table notas(Titulo varchar(45) primary key, Contenido varchar(300) not null,Fecha varchar(20)  not null)");
    }
    //metodo listar registro de la db
    public ArrayList<String> getAllRegistros()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from notas", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add("Titulo:" + res.getString(0) +" | "+"Contenido"+" "+
                    res.getString(1) + " | "+ " Fecha " + res.getString(2) );
            res.moveToNext();}
        return array_list;
    }
}
