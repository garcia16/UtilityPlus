package com.example.utilityplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.IOException;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Grabadora extends AppCompatActivity{

        //Declaro las variables
        TextView tv1;
        private MediaRecorder recorder;
        private String outputFile = null;
        int cont=0; //Declaro un contador para controlar luego errores al pulsar botones por error

        private StorageReference mStorage;
        private ProgressDialog mProgress;

        private String mFileName = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grabadora);
            //Para quitar el ActionBar
            getSupportActionBar().hide();

            mStorage = FirebaseStorage.getInstance().getReference();

            mProgress = new ProgressDialog(this);

            tv1 = (TextView) this.findViewById(R.id.tv1); // Localizamos el TextView que posteriormente vamos a ir actualizando en cada método

            mFileName =getFilesDir().getAbsolutePath();
            mFileName+="/Grabacion.3gp";
            //Con esto comprobamos los permisos de la aplicacion
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat .requestPermissions(Grabadora.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
            }


        }

        //Metodo cuando pulsamos el boton de Grabar
        public void Grabar(View view) {
            cont = 1; //Doy el valor de 1 al contador para controlar que no se rompa la aplicacion si se pulsa otro boton antes de grabar
            //Obtenemos el linear layout donde colocar los iconos
            LinearLayout iconos = (LinearLayout) findViewById(R.id.iconos);
            iconos.removeAllViewsInLayout();
            Resources res= getResources();
            ImageView microphone = new ImageView(this);
            microphone.setImageDrawable(res.getDrawable(R.drawable.microphone));
            iconos.addView(microphone); //Añadimos el icono del microfono

            recorder = new MediaRecorder(); //Creamos el archivo
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //Tipo audio
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); // Aqui le damos el formato en el que se va a guardar
            recorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            recorder.setOutputFile(mFileName); //Introducimos en el archivo creado antes el contenido de la grabacion
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
            if(cont==1) { //Si cont es 1, se podrá detener, ya que se ha dado previamente a Grabar
                //Obtenemos el linear layout donde colocar los iconos
                LinearLayout iconos = (LinearLayout) findViewById(R.id.iconos);
                iconos.removeAllViewsInLayout();
                Resources res = getResources();
                ImageView stop = new ImageView(this);
                stop.setImageDrawable(res.getDrawable(R.drawable.stop));
                iconos.addView(stop); //Añadimos el icono de Stop

                if (recorder != null) { //Si el valor de la variable no está vacio, hara lo siguiente. Lo pongo para que si se pulsa Detener sin haber iniciado no pueda dar error
                    recorder.stop(); //Se detiene la grabacion
                    recorder.release(); //Se lanza para que la guarde
                    recorder = null; //La grabacion vuuelve a estar vacia para que se pueda grabar de nuevo
                    Toast.makeText(getApplicationContext(), "El audio se ha grabado con éxito", Toast.LENGTH_LONG).show(); // Mensaje emergente de confirmacion de la detencion de la grabacion
                    tv1.setText("Detenido"); //Modifico el estado de la grabación a "Detenido"
                    cont=2; //Doy el valor de 2 para que solo si se ha deteneido se pueda reproducir despues
                }
            }else{
                Toast.makeText(this, "Antes debes grabar algo", //Este mensaje se muestra en pantalla si no se ha pulsado antes ningun numero
                        Toast.LENGTH_SHORT).show();
            }

            uploadAudio();

        }

    private void uploadAudio() {

            mProgress.setMessage("Subiendo audio...");
            mProgress.show();

            StorageReference filepatch = mStorage.child("Audio").child("new_audio.3gp");

            Uri uri = Uri.fromFile(new File(mFileName));

            filepatch.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    mProgress.dismiss();


                }
            });
    }

    //Metodo para Reproducir el contenido grabado
        public void Reproducir(View view) {
            if (cont == 2) { //Si cont es 2, se podrá reproducir, ya que se ha dado previamente a Detener
                //Obtenemos el linear layout donde colocar los iconos
                LinearLayout iconos = (LinearLayout) findViewById(R.id.iconos);
                iconos.removeAllViewsInLayout();
                Resources res = getResources();
                ImageView reproducir = new ImageView(this);
                reproducir.setImageDrawable(res.getDrawable(R.drawable.reproducir));
                iconos.addView(reproducir); //Añadimos el icono de Reproducir

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
            } else{
                Toast.makeText(this, "Antes debes grabar algo", //Este mensaje se muestra en pantalla si no se ha pulsado antes ningun numero
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
