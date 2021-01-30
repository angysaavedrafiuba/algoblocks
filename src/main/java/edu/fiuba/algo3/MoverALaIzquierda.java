package edu.fiuba.algo3;

public class MoverALaIzquierda implements Bloque {
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.mover(new Posicion2D(Posicion2D.X_IZQUIERDA, Posicion2D.Y_IZQUIERDA), tablero);
    }
}
