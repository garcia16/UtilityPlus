package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Calendario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        //Para quitar el ActionBar
        getSupportActionBar().hide();
    }
}
