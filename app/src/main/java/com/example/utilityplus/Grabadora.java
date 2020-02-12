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
    TextView tv1;
    MediaRecorder recorder;
    MediaPlayer player;
    private File outputFile = null;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabadora);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        tv1 = (TextView) this.findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            verifyPermission();
        }

    }


    private void verifyPermission() {
        int permsRequestCode = 100;
        String[] perms = {Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        int audioPermission = checkSelfPermission(Manifest.permission.RECORD_AUDIO);
        int WritePermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (audioPermission == PackageManager.PERMISSION_GRANTED && WritePermission == PackageManager.PERMISSION_GRANTED) {
            //se realiza metodo si es necesario...
        } else {
            requestPermissions(perms, permsRequestCode);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100:
                //acción o método a realizar.
                break;
        }
    }

    public void Grabar(View view) {
        outputFile = new File(Environment.getDataDirectory().
                getAbsolutePath() + "/Grabacion.3gp");
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.
                THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            recorder.setOutputFile(outputFile);
        }
        try {
            recorder.prepare();
            recorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "La grabación comenzó", Toast.LENGTH_LONG).show();
        tv1.setText("Grabando");
    }
    public void Detener(View view) {
        if (recorder != null) {
            recorder.release();
            recorder = null;
            Toast.makeText(getApplicationContext(), "El audio se ha grabado con éxito", Toast.LENGTH_LONG).show();
            tv1.setText("Listo para reproducir");
        }
    }
    public void Reproducir(View view) {
        MediaPlayer m = new MediaPlayer();

        try {
            m.setDataSource(String.valueOf(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        m.start();
        Toast.makeText(getApplicationContext(), "Reproducción de audio", Toast.LENGTH_LONG).show();
        tv1.setText("Reproduciendo");
    }



}
