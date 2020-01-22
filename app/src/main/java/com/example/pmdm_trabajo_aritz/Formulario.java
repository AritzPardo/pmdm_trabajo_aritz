package com.example.pmdm_trabajo_aritz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Formulario extends AppCompatActivity {

    TextView txtLat;
    TextView txtLong;
    EditText etLat;
    EditText etLong;
    Button btnSiguiente;
    Double lat;
    Double longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtLat = findViewById(R.id.txtLat);
        txtLong = findViewById(R.id.txtLong);
        etLat = findViewById(R.id.etLat);
        etLong = findViewById(R.id.etLong);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lat = Double.parseDouble(etLat.getText().toString());
                    longi = Double.parseDouble(etLong.getText().toString());

                    if (lat <= -90 || lat >= 90){
                        Toast.makeText(v.getContext(), "La latitud debe de estar entre -90 y 90", Toast.LENGTH_SHORT).show();
                    }else if (longi <= -180 || longi >= 180){
                        Toast.makeText(v.getContext(), "La longitud debe de estar entre -180 y 180", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                        intent2.putExtra("latitud", etLat.getText().toString());
                        intent2.putExtra("longitud", etLong.getText().toString());
                        v.getContext().startActivity(intent2);
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(v.getContext(), "Inserta los valores", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
