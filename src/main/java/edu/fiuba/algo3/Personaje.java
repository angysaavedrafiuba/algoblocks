package edu.fiuba.algo3;

public class Personaje {
    private final Lapiz lapiz;
    public Posicion2D posicion;

    /* constructor */
    public Personaje(Posicion2D posicionInicial) {
        this.posicion = posicionInicial;
        this.lapiz = new Lapiz();
    }

    public void subirLapiz() {
        lapiz.levantar();
    }

    public void bajarLapiz() {
        lapiz.apoyar();
    }

    public void mover(Posicion2D posicion, Dibujo dibujo) {
        this.posicion.mover(posicion);
        dibujo.dibujarConLapiz(this.posicion, this.lapiz);
    }

    /* Test only */
    public boolean lapizEstaArriba() {
        return lapiz.LapizArriba();
    }

    public boolean estaEn(Posicion2D posicion) {
        return posicion.esLaMismaQue(posicion);
    }
}


