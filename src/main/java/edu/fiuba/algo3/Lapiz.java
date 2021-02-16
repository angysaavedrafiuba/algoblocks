package edu.fiuba.algo3;

public class Lapiz {
    Punta punta = new PuntaLevantada();

    void dibujar(Dibujo dibujo, Posicion2D posicionADibujar) {
        punta.dibujar(dibujo, posicionADibujar);
    }

    public void levantar() {
        punta = new PuntaLevantada();
    }

    public void apoyar() {
        punta = new PuntaApoyada();
    }

    /* Test only */
    boolean LapizArriba() {
        return this.punta.estaLevantada();
    }
}
