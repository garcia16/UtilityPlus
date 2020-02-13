package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para quitar el ActionBar
        getSupportActionBar().hide();
    }
    //Método vinculado al boton "Calendario" para que se inicie la Activity
    public void Calendario(View view){
        startActivity(new Intent(this, Calendario.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
    }
    //Método vinculado al boton "Grabadora" para que se inicie la Activity
    public void Grabadora(View view){
        startActivity(new Intent(this, Grabadora.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
    }
    //Método vinculado al boton "Notas" para que se inicie la Activity
    public void Notas(View view){
        startActivity(new Intent(this, Notas.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
    }
    //Método vinculado al boton "Calculadora" para que se inicie la Activity
    public void Calculadora(View view){
        startActivity(new Intent(this, Calculadora.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out); //Transicion entre Activities
    }
}
