package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NotaNueva extends AppCompatActivity {

    private EditText Titulo ;
    private EditText Contenido;
    private EditText Fecha;
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
        Intent intent = new Intent(this, Notas.class);
        intent.putExtra("dato", Titulo.getText().toString());
        intent.putExtra("dato2", Contenido.getText().toString());
        intent.putExtra("dato3", Fecha.getText().toString());

        //Obtenemos el linear layout donde colocar los botones
        LinearLayout Notas = (LinearLayout) findViewById(R.id.LinearNotas);

        //Creamos los TextView en bucle
        TextView textView = new TextView(this);
        textView.setText((CharSequence) Contenido);

        //Asignamos el Listener
        textView.setOnClickListener(new TextViewsOnClickListener(this));
        //Añadimos el textView al LinearLayout
        Notas.addView(textView);

        startActivity(intent);
    }
    class TextViewsOnClickListener implements View.OnClickListener {

        public TextViewsOnClickListener(NotaNueva notas) {
        }

        @Override
        public void onClick(View v) { //Este mensaje aparecerá al pulsar el boton de Guardar
            Toast.makeText(getApplicationContext(),"Nota Guardada",Toast.LENGTH_SHORT).show();
        }
    }
}
