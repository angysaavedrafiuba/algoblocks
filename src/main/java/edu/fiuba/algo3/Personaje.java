package edu.fiuba.algo3;

public class Personaje {
    private Lapiz lapiz;
    private Posicion2D posicion;

    /* constructor */
    public Personaje(Posicion2D posicionInicial) {
        this.posicion = posicionInicial;
        this.lapiz = new LapizConPuntaHaciaArriba();
    }

    public boolean lapizEstaArriba() {
        return lapiz.LapizArriba();
    }

    public void setLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }

    public boolean estaEn(Posicion2D posicion) {
        return posicion.estaEn(posicion);
    }

    public void mover(Posicion2D posicion, Tablero tablero) {
        this.posicion.mover(posicion);
        tablero.dibujarEnConLapiz(this.posicion, this.lapiz);
    }

}


