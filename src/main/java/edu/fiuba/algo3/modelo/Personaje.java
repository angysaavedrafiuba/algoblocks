package edu.fiuba.algo3.modelo;

public class Personaje {
    private final Lapiz lapiz;
    public Posicion2D posicion;

    /* constructor */
    public Personaje(Posicion2D posicionInicial) {
        this.posicion = posicionInicial;
        this.lapiz = new Lapiz();
    }

    public void levantarLapiz() {
        lapiz.levantar();
    }

    public void apoyarLapiz() {
        lapiz.apoyar();
    }

    public void mover(Posicion2D posicion, Dibujo dibujo) {
        this.posicion = this.posicion.calcularNuevaPosicion(posicion);
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


