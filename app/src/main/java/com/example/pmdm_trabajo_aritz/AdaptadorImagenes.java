package com.example.pmdm_trabajo_aritz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorImagenes extends RecyclerView.Adapter<AdaptadorImagenes.ViewHolder> {
    //Creamos una lista del tipo de nuestra clase
    private List<Resultado> listaResultado;
    private MediaPlayer mediaplayer;

    // Constructor del adaptador
    public AdaptadorImagenes(List<Resultado> listaResultado) {
        this.listaResultado = listaResultado;
    }

    // Colocamos el xml del elemento selector
    @Override
    public AdaptadorImagenes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_selector_mostrar, parent, false);
        AdaptadorImagenes.ViewHolder viewHolder = new AdaptadorImagenes.ViewHolder(v);
        return viewHolder;
    }

    // Aqui ponemos los elementos que se muestran en pantalla
    @Override
    public void onBindViewHolder(final AdaptadorImagenes.ViewHolder holder, final int position) {
        final String nombre = listaResultado.get(position).getNombre();
        final String imgRecycler = listaResultado.get(position).getNombreImagen();
        int resID = holder.itemView.getResources().getIdentifier(imgRecycler , "drawable", holder.itemView.getContext().getPackageName());
        holder.imgRecycler.setImageResource(resID);
        holder.nombre.setText(nombre);

        // Aquí programamos el click del elemento del recyclerview
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "Recycle Click: " + nombre, Toast.LENGTH_SHORT).show();

                mediaplayer = MediaPlayer.create(view.getContext(), R.raw.misc021);
                mediaplayer.start();

                Intent intent = new Intent(view.getContext(), UltimaPantalla.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("nombreImagen", imgRecycler);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaResultado.size();
    }

    // Esto es necesario
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Aqui tambien ponemos los elementos del elemento selector
        private TextView nombre;
        private ImageView imgRecycler;
        public ViewHolder(View v) {
            super(v);
            imgRecycler = v.findViewById(R.id.imgImagene);
            nombre = (TextView) v.findViewById(R.id.txtRecyclerText);
        }
    }
}
