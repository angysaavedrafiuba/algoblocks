package edu.fiuba.algo3;

public class MoverHaciaArriba implements Bloque {
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.mover(new Posicion2D(Posicion2D.X_ARRIBA, Posicion2D.Y_ARRIBA), tablero);
    }
}