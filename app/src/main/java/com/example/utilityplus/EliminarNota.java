package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarNota extends AppCompatActivity {
    ListView listaView;
    DbHelper admin;
    SQLiteDatabase db;
    private Cursor fila;
    private EditText Eliminar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_nota);
        //Para quitar el ActionBar
        getSupportActionBar().hide();
        Eliminar = (EditText) findViewById(R.id.Eliminar);
        //Declaramos el ListView en el cual tambien se vera la lista de notas
        ListView listaView = (ListView) findViewById(R.id.lista);

        //Llamo al metodo getAllRegistrosEliminar que lista todos lo datos registrados de la base de datos y nos muestra su codigo, a diferencia de la Activity Notas, que no mostraba el codigo
        admin = new DbHelper(this, "notas", null, 1);
        ArrayList array_list = admin.getAllRegistrosEliminar();
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter);
    }

    public void Eliminar(View view){
        admin = new DbHelper(this, "notas", null, 1); //Conectamos con la base de datos y nuestra tabla
        db = admin.getWritableDatabase();
        String codigo = Eliminar.getText().toString(); //Obtenemos el codigo que introduce el usuario de la nota que quiere borrar
        int cant = db.delete("notas", "Codigo=" + codigo, null);
        db.close(); //Cerramos la conexion con la base de datos
        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter); //Se actualiza el Array

        if (cant == 1) {
            Toast.makeText(this, "Nota Eliminada", //Mensaje en caso de que se haya eliminado la nota correctamente
                    Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Esa nota no existe", //Mensaje en caso de que la nota no se elimine
                    Toast.LENGTH_SHORT).show();
    }

    }

