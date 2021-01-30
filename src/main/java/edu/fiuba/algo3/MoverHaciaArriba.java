package edu.fiuba.algo3;

public class MoverHaciaArriba implements Bloque {
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.mover(Posicion2D.ARRIBA, tablero);
    }
}