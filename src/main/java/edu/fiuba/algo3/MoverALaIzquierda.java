package edu.fiuba.algo3;

public class MoverALaIzquierda extends Bloque {
    MoverALaIzquierda() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_IZQUIERDA, Posicion2D.Y_IZQUIERDA), dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new MoverALaDerecha();
    }
}
