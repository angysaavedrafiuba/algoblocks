package edu.fiuba.algo3;

public class Personaje {
    private Lapiz lapiz;
    public Posicion2D posicion;

    /* constructor */
    public Personaje(Posicion2D posicionInicial) {
        this.posicion = posicionInicial;
        this.lapiz = new LapizConPuntaHaciaArriba();
    }

    public void setLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }

    public boolean estaEn(Posicion2D posicion) {
        return posicion.igualA(posicion);
    }

    public void mover(Posicion2D posicion, Dibujo dibujo) {
        this.posicion.mover(posicion);
        dibujo.dibujarConLapiz(this.posicion, this.lapiz);
    }

    /* Test only */

    public boolean lapizEstaArriba() {
        return lapiz.LapizArriba();
    }
}


