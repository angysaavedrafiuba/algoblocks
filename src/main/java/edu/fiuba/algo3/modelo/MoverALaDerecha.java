package edu.fiuba.algo3.modelo;

public class MoverALaDerecha implements EstadoDeBloque {
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(Posicion2D.derecha(), dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return new MoverALaIzquierda();
    }

    @Override
    public String toString() {
        return "MoverALaDerecha{}";
    }
}