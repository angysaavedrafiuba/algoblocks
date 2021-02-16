package edu.fiuba.algo3.modelo;

public class Lapiz {
    Punta estado = new PuntaLevantada();

    void dibujar(Dibujo dibujo, Posicion2D posicionADibujar) {
        estado.dibujar(dibujo, posicionADibujar);
    }

    public void levantar() {
        estado = new PuntaLevantada();
    }

    public void apoyar() {
        estado = new PuntaApoyada();
    }

    /* Test only */
    boolean LapizArriba() {
        return this.estado.estaLevantada();
    }
}
