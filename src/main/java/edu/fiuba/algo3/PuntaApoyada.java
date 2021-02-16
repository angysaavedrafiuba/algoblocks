package edu.fiuba.algo3;

public class PuntaApoyada implements Punta {
    public void dibujar(Dibujo dibujo, Posicion2D posicionADibujar) {
        dibujo.dibujar(posicionADibujar);
    }

    /* Test only */
    public boolean estaLevantada() {
        return false;
    }
}
