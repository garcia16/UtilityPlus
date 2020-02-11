package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NotaNueva extends AppCompatActivity {
    private EditText Titulo ;
    private EditText Contenido;
    private EditText Fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_nueva);
        getSupportActionBar().hide();

        Titulo = (EditText) findViewById(R.id.Titulo);
        Contenido = (EditText) findViewById(R.id.Contenido);
        Fecha = (EditText) findViewById(R.id.Fecha);
    }
    public void GuardarNota(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("dato", Titulo.getText().toString());
        intent.putExtra("dato2", Contenido.getText().toString());
        intent.putExtra("dato3", Fecha.getText().toString());
        startActivity(intent);
    }
}
