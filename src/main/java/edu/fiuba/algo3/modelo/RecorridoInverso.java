package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RecorridoInverso extends Recorrido{

    RecorridoInverso(){
        this.bloques = new ArrayList<Bloque>();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.forEach(bloque -> bloque.ejecutar(personaje, dibujo));
    }

    @Override
    void agregarBloque(Bloque bloque) {
        bloque.invertir();
        this.bloques.add(bloque);
    }

    @Override
    public Recorrido invertir() {
        RecorridoNormal nuevoRecorrido = new RecorridoNormal();
        bloques.forEach(bloque -> nuevoRecorrido.agregarBloque(bloque));
        return nuevoRecorrido;
    }
}
