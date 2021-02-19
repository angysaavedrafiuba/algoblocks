package edu.fiuba.algo3.modelo;

public class MoverHaciaArriba implements EstadoDeBloque {
    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(Posicion2D.arriba(), dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return new MoverHaciaAbajo();
    }

    @Override
    public void agregarBloque(Bloque bloque) {

    }
}