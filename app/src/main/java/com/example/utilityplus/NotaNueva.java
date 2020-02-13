package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NotaNueva extends AppCompatActivity {

    private EditText Titulo ;
    private EditText Contenido;
    private EditText Fecha;

    private Cursor fila;
    ListView listaView;

    DbHelper admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_nueva);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        Titulo = (EditText) findViewById(R.id.Titulo);
        Contenido = (EditText) findViewById(R.id.Contenido);
        Fecha = (EditText) findViewById(R.id.Fecha);


    }
    public void GuardarNota(View view) {

        admin = new DbHelper(this, "notas", null, 1);
        db = admin.getWritableDatabase();
        String titulo = Titulo.getText().toString();
        String contenido = Contenido.getText().toString();
        String fecha = Fecha.getText().toString();

        //insertamos en la db
        ContentValues notas = new ContentValues();
        notas.put("Titulo", titulo);
        notas.put("Contenido", contenido);
        notas.put("Fecha", fecha);
        db.insert("notas", null, notas);
        db.close();
        Toast.makeText(this, "La nota se ha guardado ",
                Toast.LENGTH_SHORT).show();
        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);

        listaView.setAdapter(arrayAdapter);



        Intent intent = new Intent(this, Notas.class);
        startActivity(intent);
    }

}
