package com.example.pmdm_trabajo_aritz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private MapView mapView;
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // El token de acceso se configura aquí. Necesita ser llamado
        // en el activity que contiene el mapview (este)
        Mapbox.getInstance(this, getString(R.string.access_token));

        // Este layout contiene el MapView en el XML y necesita ser
        // llamado después del token de acceso.
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // Recogemos los valores que el usuario ha escogido
        Intent intent = getIntent();
        final String latitud = intent.getStringExtra("latitud");
        final String longitud = intent.getStringExtra("longitud");

        //Creamos el punto de localizacion
        String[] latlong = (latitud + "," + longitud).split(",");
        double lat = Double.parseDouble(latlong[0]);
        double longi = Double.parseDouble(latlong[1]);
        final LatLng location = new LatLng(lat, longi);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        // Creamos una posición de camara para centrar la visión del mapa en el marker
                        CameraPosition position = new CameraPosition.Builder()
                                .target(new LatLng(location))
                                .zoom(5)
                                .tilt(20)
                                .build();

                        // Añadimos el marker con la localización dada por el usuario
                        mapboxMap.addMarker(new MarkerOptions().position(location).title("Punto Escogido"));
                        mapboxMap.setCameraPosition(position);

                        // El metodo al clickar en el marker
                        mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {
                                // El sonido
                                mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.misc021);
                                mediaplayer.start();

                                Intent intent = new Intent(getApplicationContext(), MostrarRecyclerActivity.class);
                                startActivity(intent);
                                return false;
                            }
                        });
                    }
                });
            }
        });
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
