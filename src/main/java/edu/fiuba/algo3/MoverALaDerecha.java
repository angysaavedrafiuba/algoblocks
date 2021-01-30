package edu.fiuba.algo3;

public class MoverALaDerecha implements Bloque {
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.mover(new Posicion2D(Posicion2D.X_DERECHA, Posicion2D.Y_DERECHA), tablero);
    }
}