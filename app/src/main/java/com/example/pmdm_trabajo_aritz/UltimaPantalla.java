package com.example.pmdm_trabajo_aritz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UltimaPantalla extends AppCompatActivity {

    ImageView imgUltima;
    TextView txtUltima;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima);

        imgUltima = findViewById(R.id.imgUltima);
        txtUltima = findViewById(R.id.txtUltima);

        // Ponemos los valores que el usuario ha escogido
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String nombreImagen = intent.getStringExtra("nombreImagen");

        final String imgTitulo = nombreImagen;
        int resID = getResources().getIdentifier(imgTitulo , "drawable", this.getPackageName());

        imgUltima.setImageResource(resID);
        txtUltima.setText(nombre);
    }
}
