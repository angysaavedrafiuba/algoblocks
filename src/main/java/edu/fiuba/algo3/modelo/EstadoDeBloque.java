package edu.fiuba.algo3.modelo;

public interface EstadoDeBloque {

    void ejecutar(Personaje personaje, Dibujo dibujo);

    EstadoDeBloque invertir();

    void agregarBloque(Bloque bloque);
}
