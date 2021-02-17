package edu.fiuba.algo3.modelo;

public interface Recorrido {
    void ejecutar(Personaje personaje, Dibujo dibujo);

    void agregarBloque(Bloque bloque);

    void invertir();

    void reiniciar();
}