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
    public void Calendario(View view){
        startActivity(new Intent(this, Calendario.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }
    public void Grabadora(View view){
        startActivity(new Intent(this, Grabadora.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }
    public void Notas(View view){
        startActivity(new Intent(this, Notas.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }
    public void Calculadora(View view){
        startActivity(new Intent(this, Calculadora.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }
}
