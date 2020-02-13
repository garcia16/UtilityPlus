package com.example.utilityplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.IOException;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Grabadora extends AppCompatActivity{

        //Declaro las variables
        TextView tv1;
        private MediaRecorder recorder;
        private String outputFile = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grabadora);
            //Para quitar el ActionBar
            getSupportActionBar().hide();
            tv1 = (TextView) this.findViewById(R.id.tv1); // Localizamos el TextView que posteriormente vamos a ir actualizando en cada método

            //Con esto comprobamos los permisos de la aplicacion
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat .requestPermissions(Grabadora.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
            }
        }
        //Metodo cuando pulsamos el boton de GRabar
        public void Grabar(View view) {
            outputFile = getFilesDir(). //Establecemos que el archivo de audio se va a grabar en la mamoria interna del dispositivo, en caso de querer que fuese en la SD
                    getAbsolutePath() + "/Grabacion.3gp"; //lo que hariamos es darle "nvironment.getExternalStorageDirectory()" ya que hemos establecido el permiso.
            recorder = new MediaRecorder(); //Creamos el archivo
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //Tipo audio
            recorder.setOutputFormat(MediaRecorder.OutputFormat.
                    THREE_GPP); // Aqui le damos el formato en el que se va a guardar
            recorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            recorder.setOutputFile(outputFile); //Introducimos en el archivo creado antes el contenido de la grabacion
            try {
                recorder.prepare();
                recorder.start(); //Se inicia la grabación del audio
                Toast.makeText(getApplicationContext(), "La grabación comenzó", Toast.LENGTH_LONG).show(); // Mensaje emergente de confirmacion del inicio de la grabacion
                tv1.setText("Grabando"); //Modifico el estado de la grabación a "Grabando"
                //EXCEPCIONES
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //Metodo para Detener la grabacion y que se guarde
        public void Detener(View view) {
            if (recorder != null) { //Si el valor de la variable no está vacio, hara lo siguiente. Lo pongo para que si se pulsa Detener sin haber iniciado no pueda dar error
                recorder.stop(); //Se detiene la grabacion
                recorder.release(); //Se lanza para que la guarde
                recorder = null; //La grabacion vuuelve a estar vacia para que se pueda grabar de nuevo
                Toast.makeText(getApplicationContext(), "El audio se ha grabado con éxito", Toast.LENGTH_LONG).show(); // Mensaje emergente de confirmacion de la detencion de la grabacion
                tv1.setText("Detenido"); //Modifico el estado de la grabación a "Detenido"
            }
        }
        //Metodo para Reproducir el contenido grabado
        public void Reproducir(View view) {
            MediaPlayer m = new MediaPlayer(); //Creamos el reproductor
            try {
                m.setDataSource(outputFile); //Le damos al reproductor el contenido del archivo creado anteriormente
            } catch (IOException e) {
                e.printStackTrace(); //Controlo excepciones
            }
            try {
                m.prepare();
            } catch (IOException e) {
                e.printStackTrace(); //Controlo excepciones
            }
            m.start(); //Inicio la reproduccion del archivo
            Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_LONG).show(); //Mensaje emergente que indica que se está reproduciendo el audio
            tv1.setText("Reproduciendo"); //Modifico el estado de la grabación a "Reproduciendo"
        }

    }
