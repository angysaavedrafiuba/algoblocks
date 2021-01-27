package edu.fiuba.algo3;

public class MoverALaDerecha implements Bloque {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.mover(Posicion2D.DERECHA);
    }
}