package com.example.pmdm_trabajo_aritz;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MostrarRecyclerActivity extends AppCompatActivity {

    RecyclerView reyclerViewTitulos;
    AdaptadorImagenes adaptadorRecycler;
    ArrayList<Resultado> listaResultado = new ArrayList<Resultado>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        reyclerViewTitulos = (RecyclerView) findViewById(R.id.recyclerViewMostrar);

        Resultado Europa_Este = new Resultado("Parque Europa desde el este", "foto1");
        Resultado Europa_SudEste = new Resultado("Parque Europa desde el sudeste", "foto2");
        Resultado Europa_Sur = new Resultado("Parque Europa desde el sur", "foto3");
        Resultado Europa_Rotonda = new Resultado("Parque Europa desde la rotonda", "foto4");
        Resultado Fuente = new Resultado("El insituto, fuente de gozo", "foto5");
        Resultado Arbusto = new Resultado("Arbustos grandes.", "foto6");

        listaResultado.add(Europa_Este);
        listaResultado.add(Europa_SudEste);
        listaResultado.add(Europa_Sur);
        listaResultado.add(Europa_Rotonda);
        listaResultado.add(Fuente);
        listaResultado.add(Arbusto);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        reyclerViewTitulos.setHasFixedSize(true);

        // Colocamos 3 columnas en el recyclerView
        reyclerViewTitulos.setLayoutManager (new GridLayoutManager(this, 3));

        // specify an adapter with the list to show
        adaptadorRecycler = new AdaptadorImagenes(listaResultado);
        reyclerViewTitulos.setAdapter(adaptadorRecycler);

    }
}
