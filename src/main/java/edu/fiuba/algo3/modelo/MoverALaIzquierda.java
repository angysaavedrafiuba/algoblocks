package edu.fiuba.algo3.modelo;

public class MoverALaIzquierda implements EstadoDeBloque {
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(Posicion2D.izquierda(), dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return new MoverALaDerecha();
    }

}
