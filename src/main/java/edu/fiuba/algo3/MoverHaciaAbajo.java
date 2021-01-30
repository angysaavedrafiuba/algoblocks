package edu.fiuba.algo3;

public class MoverHaciaAbajo implements Bloque {
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.mover(new Posicion2D(Posicion2D.X_ABAJO, Posicion2D.Y_ABAJO), tablero);
    }
}
