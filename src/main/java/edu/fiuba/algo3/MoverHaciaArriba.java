package edu.fiuba.algo3;

public class MoverHaciaArriba extends Bloque {
    MoverHaciaArriba() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_ARRIBA, Posicion2D.Y_ARRIBA), dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new MoverHaciaAbajo();
    }
}