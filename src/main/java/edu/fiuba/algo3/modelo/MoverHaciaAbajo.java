package edu.fiuba.algo3.modelo;

public class MoverHaciaAbajo implements EstadoDeBloque {
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(Posicion2D.abajo(), dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return new MoverHaciaArriba();
    }

    @Override
    public String toString() {
        return "MoverHaciaAbajo{}";
    }
}
