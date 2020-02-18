package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Notas extends AppCompatActivity {
    ListView listaView;
    DbHelper admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        ListView listaView = (ListView) findViewById(R.id.lista); //Localizamos la ListView donde introduciremos nuestras notas

        //Llamo al metodo getAllRegistros que lista todos lo datos registrados de la base de datos.
        admin = new DbHelper(this, "notas", null, 1);
        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter);
    }

    //Método vinculado al boton "NotaNueva" para que se inicie la Activity
    public void NotaNueva(View view){
        startActivity(new Intent(this, NotaNueva.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
    }
    //Método vinculado al boton "EliminarNota" para que se inicie la Activity
    public void EliminarNota(View view){
        startActivity(new Intent(this, EliminarNota.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
        finish();
    }
}
