package edu.fiuba.algo3;

public class MoverALaDerecha extends Bloque {
    MoverALaDerecha() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_DERECHA, Posicion2D.Y_DERECHA), dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new MoverALaIzquierda();
    }
}