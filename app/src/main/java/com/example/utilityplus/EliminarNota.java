package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class EliminarNota extends AppCompatActivity {
    ListView listaView;
    DbHelper admin;
    SQLiteDatabase db;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_nota);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        ListView listaView = (ListView) findViewById(R.id.lista);
    }

    public void Eliminar(View view){

    }
}
