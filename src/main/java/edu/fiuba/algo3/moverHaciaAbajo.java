package edu.fiuba.algo3;

public class moverHaciaAbajo implements Bloque {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.mover(new Posicion2D(0, -1));
    }
}
