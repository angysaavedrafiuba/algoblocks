package edu.fiuba.algo3;

public class moverALaIzquierda implements Bloque {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.mover(new Posicion2D(-1, 0));
    }
}
