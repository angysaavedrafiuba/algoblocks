package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RecorridoInverso extends Recorrido{

    RecorridoInverso(){
        this.bloques = new ArrayList<Bloque>();
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

    @Override
    public Recorrido clonar() {
        RecorridoInverso recorridoClonado = new RecorridoInverso();
        recorridoClonado.clonar(bloques);
        return recorridoClonado;
    }

    private void clonar(List<Bloque> bloques){
        this.bloques = new ArrayList<Bloque>();
        bloques.forEach(bloque -> this.bloques.add(bloque.clonar()));
    }
}
