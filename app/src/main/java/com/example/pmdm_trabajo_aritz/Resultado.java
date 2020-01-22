package com.example.pmdm_trabajo_aritz;

public class Resultado {

    String nombre;
    String nombreImagen;

    public Resultado (String nombre, String nombreImagen){
        this.nombre = nombre;
        this.nombreImagen = nombreImagen;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getNombreImagen(){
        return nombreImagen;
    }
}
