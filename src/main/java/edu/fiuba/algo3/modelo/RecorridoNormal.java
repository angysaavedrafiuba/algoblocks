package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RecorridoNormal {
    ArrayList<Bloque> bloques = new ArrayList<>();

    public void agregarBloque(Bloque bloque){
        this.bloques.add(bloque);
    }

    public RecorridoNormal invertir() {
        bloques.forEach(Bloque::invertir);
        return this;
    }

    public RecorridoNormal clonar() {
        RecorridoNormal recorridoClonado = new RecorridoNormal();
        recorridoClonado.clonar(bloques);
        return recorridoClonado;
    }

    private void clonar(List<Bloque> bloques){
        this.bloques = new ArrayList<>();
        bloques.forEach(bloque -> this.bloques.add(bloque.clonar()));
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.bloques.forEach(bloque -> bloque.ejecutar(personaje, dibujo));
    }

    void reiniciar(){
        this.bloques = new ArrayList<>();
    }

    void removerUltimo(){
        if(!bloques.isEmpty())
            bloques.remove(bloques.size() - 1);
    }
}
