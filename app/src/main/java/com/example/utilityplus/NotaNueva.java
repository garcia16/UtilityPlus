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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NotaNueva extends AppCompatActivity {

    private EditText Titulo ;
    private EditText Contenido;
    private EditText Fecha;

    private Cursor fila;
    ListView listaView;

    DbHelper admin;
    SQLiteDatabase db;

    //Calendar c = Calendar.getInstance();
    //Calendar c1 = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_nueva);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        //Declaro los PlainText que voy a usar
        Titulo = (EditText) findViewById(R.id.Titulo);
        Contenido = (EditText) findViewById(R.id.Contenido);
        Fecha = (EditText) findViewById(R.id.Fecha);

       // String dia = Integer.toString(c.get(Calendar.DATE));
       // String mes = Integer.toString(c.get(Calendar.MONTH));
       // String ano = Integer.toString(c.get(Calendar.YEAR));
       // String Fecha2 = (dia+"/"+mes+"/"+ano);

    }
    public void GuardarNota(View view) {

        int numeroAleatorio = (int) (Math.random()*100+1); //Hago un MathRandom para que luego se le asigne un codigo a cada nota, de cara a eliminarlas despues

        admin = new DbHelper(this, "notas", null, 1);
        db = admin.getWritableDatabase();
        String titulo = Titulo.getText().toString();
        String contenido = Contenido.getText().toString();
        String fecha = Fecha.getText().toString();
       // String fecha2 = Fecha2.getText().toString();

        //Insertamos en la base de datos
        ContentValues notas = new ContentValues();
        notas.put("Codigo",numeroAleatorio);
        notas.put("Titulo", titulo);
        notas.put("Contenido", contenido);
        notas.put("Fecha", fecha);
       // notas.put("Fecha2", fecha2);
        db.insert("notas", null, notas); //Finalmente se introduce en la tabla Notas
        db.close(); //Cerramos la conexion con la base de datos

        Toast.makeText(this, "La nota se ha guardado ", //Este mensaje se muestra en pantalla una vez que se ha guardado la nota con exito
                Toast.LENGTH_SHORT).show();
        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);

        //REGRESAMOS A LA ACTIVITY NOTAS
        Intent intent = new Intent(this, Notas.class);
        startActivity(intent);
    }

}
