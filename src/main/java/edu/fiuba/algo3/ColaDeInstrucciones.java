package edu.fiuba.algo3;


public class ColaDeInstrucciones {
    private final Recorrido recorrido;

    ColaDeInstrucciones(Bloque primerBloque, Recorrido recorrido){
        this.recorrido = recorrido;
        recorrido.agregar(primerBloque);
    }

    ColaDeInstrucciones(Recorrido recorrido){
        this.recorrido = recorrido;
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        recorrido.primerBloque().ejecutar(personaje, dibujo);
    }

    public void agregarBloque(Bloque bloque){
        recorrido.primerBloque().enlazar(bloque, recorrido);
    }
}
