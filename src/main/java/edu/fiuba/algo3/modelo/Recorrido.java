package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Recorrido {
    protected ArrayList<Bloque> bloques;

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.bloques.forEach(bloque -> bloque.ejecutar(personaje, dibujo));
    }

    abstract void agregarBloque(Bloque bloque);

    void reiniciar(){
        this.bloques = new ArrayList<Bloque>();
    }

    void removerUltimo(){
        if(!bloques.isEmpty())
            bloques.remove(bloques.size() - 1);
    }

    public abstract Recorrido invertir();
}