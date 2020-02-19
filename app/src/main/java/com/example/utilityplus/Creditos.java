package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Creditos extends AppCompatActivity {

    WebView miVisorWeb;
    String url = "https://github.com/garcia16";
    String url2 = "https://www.linkedin.com/in/jose-luis-garcia-san-pedro-98314b196/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb);

        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);

        miVisorWeb.loadUrl(url);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Inicio();
                return true;
            case R.id.action_nuevo:
                creacion();
                return true;
            case R.id.home:
                onBackPressed();
                default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void creacion() {
        Toast.makeText(this, "Está aplicacion fue creada por Jose Luis Garcia para la clase de Programacion de dispositivos moviles", //Mensaje en caso de que se haya eliminado la nota correctamente
                Toast.LENGTH_LONG).show();
    }

    public void Inicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
