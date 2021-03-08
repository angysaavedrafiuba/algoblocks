package edu.fiuba.algo3.modelo;

public interface Estado {
    void ejecutar(Personaje personaje, Dibujo dibujo);

    EstadoDeBloque invertir();

    String toString();
}
