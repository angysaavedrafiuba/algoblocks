package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class RecorridoNormal extends Recorrido {

    RecorridoNormal() {
        this.bloques = new ArrayList<Bloque>();
    }

    @Override
    public void agregarBloque(Bloque bloque){
        this.bloques.add(bloque);
    }

    @Override
    public Recorrido invertir() {
        RecorridoInverso nuevoRecorrido = new RecorridoInverso();
        bloques.forEach(bloque -> nuevoRecorrido.agregarBloque(bloque));
        return nuevoRecorrido;
    }
}
