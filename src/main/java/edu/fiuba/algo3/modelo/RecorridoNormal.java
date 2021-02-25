package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Recorrido clonar() {
        RecorridoNormal recorridoClonado = new RecorridoNormal();
        recorridoClonado.clonar(bloques);
        return recorridoClonado;
    }

    private void clonar(List<Bloque> bloques){
        this.bloques = new ArrayList<Bloque>();
        bloques.forEach(bloque -> this.bloques.add(bloque.clonar()));
    }
}
