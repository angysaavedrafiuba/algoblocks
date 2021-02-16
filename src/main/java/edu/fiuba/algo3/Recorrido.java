package edu.fiuba.algo3;

public interface Recorrido {
    void ejecutar(Personaje personaje, Dibujo dibujo);

    void agregarBloque(Bloque bloque);

    void invertir();
}