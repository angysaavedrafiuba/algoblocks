package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class BloquePersonalizado implements EstadoDeBloque{
    private String nombre;
    private ArrayList<Bloque> secuencia;

   public BloquePersonalizado(String nombre, ArrayList<Bloque> secuenciaDeBloques){
       this.secuencia = new ArrayList<>();
       this.nombre = nombre;
       this.guardarSecuencia(secuenciaDeBloques);
   }
    public void guardarSecuencia(ArrayList<Bloque> algoritmo){
        this.secuencia.addAll(algoritmo);
    }

    private ArrayList<Bloque> copiar(ArrayList<Bloque> arrayACopiar){
        ArrayList<Bloque> nuevoArray = new ArrayList<>();
        nuevoArray.addAll(arrayACopiar);
        return nuevoArray;
   }

   public String obtenerNombre(){
       return this.nombre;
   }
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.secuencia.forEach(bloque -> bloque.ejecutar(personaje,dibujo));
    }

    @Override
    public EstadoDeBloque invertir() {
        ArrayList<Bloque> copia = this.copiar(secuencia);
        copia.forEach(Bloque::invertir);
        return this;
    }
}
