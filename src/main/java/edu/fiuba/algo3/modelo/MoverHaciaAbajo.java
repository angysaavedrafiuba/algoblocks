package edu.fiuba.algo3.modelo;

public class MoverHaciaAbajo extends Bloque {
    MoverHaciaAbajo() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        personaje.mover(new Posicion2D(Posicion2D.X_ABAJO, Posicion2D.Y_ABAJO), dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        return new MoverHaciaArriba();
    }


}
