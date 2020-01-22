package com.example.pmdm_trabajo_aritz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Formulario extends AppCompatActivity {

    TextView txtLat;
    TextView txtLong;
    EditText etLat;
    EditText etLong;
    Button btnSiguiente;

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
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                intent2.putExtra("latitud", etLat.getText().toString());
                intent2.putExtra("longitud", etLong.getText().toString());
                v.getContext().startActivity(intent2);
            }
        });



    }
}
