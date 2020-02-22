package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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


    WebView miVisorWeb; //Declaro el WebView

    //URLS a las que acceder desde el boton que tiene mi nombre
    String url = "https://github.com/garcia16";
    String url2 = "https://www.linkedin.com/in/jose-luis-garcia-san-pedro-98314b196/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb); //WebView en el que se pueden ver mis repositorios de GitHub

        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);

        miVisorWeb.loadUrl(url); //Cargo la url que he seleccionado
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Opciones de los items del Menu
        switch (item.getItemId()) {
            case R.id.action_settings:
                Inicio();
                return true;
            case R.id.action_nuevo:
                creacion();
                return true;
            case R.id.home:
                onBackPressed();
            case R.id.linkedin:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(browserIntent); //En caso de pulsar me llevara al enlace que tengo definido arriba
            case R.id.github:
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent2); //En caso de pulsar me llevara al otro enlace que tengo definido arriba
                default:
                return super.onOptionsItemSelected(item);
        }
    }
        //Metodo para indicar quien es el creador de la app
    private void creacion() {
        Toast.makeText(this, "Está aplicacion fue creada por Jose Luis Garcia para la clase de Programacion de Dispositivos Moviles en Febrero de 2020", //Mensaje en caso de que se haya eliminado la nota correctamente
                Toast.LENGTH_LONG).show(); //Mensaje emergente
    }
        //Metodo para regresar a la pantalla de inicio
    public void Inicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
