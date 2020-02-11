package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Notas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        //Para quitar el ActionBar
        getSupportActionBar().hide();
    }

    public void NotaNueva(View view){
        startActivity(new Intent(this, NotaNueva.class));
        overridePendingTransition(R.transition.zoom_forward_in, R.transition.zoom_forward_out);
    }
}
