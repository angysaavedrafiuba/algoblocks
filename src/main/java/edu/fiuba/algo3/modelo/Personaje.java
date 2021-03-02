package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.TimeUnit;

public class Personaje {
    private final Lapiz lapiz;
    public Posicion2D posicion;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /* constructor */
    public Personaje(Posicion2D posicionInicial) {
        this.posicion = posicionInicial;
        support.firePropertyChange("posicion", null, posicion);
        this.lapiz = new Lapiz();
    }

    public void levantarLapiz() {
        lapiz.levantar();
    }

    public void apoyarLapiz() {
        lapiz.apoyar();
    }

    public void mover(Posicion2D posicion, Dibujo dibujo) {
        Posicion2D nuevaPosicion = this.posicion.calcularNuevaPosicion(posicion);
        support.firePropertyChange("posicion", this.posicion, nuevaPosicion);
        dibujo.dibujarConLapiz(nuevaPosicion, this.lapiz);
        this.posicion = nuevaPosicion;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /* Test only */
    public boolean lapizEstaArriba() {
        return lapiz.LapizArriba();
    }

    public boolean estaEn(Posicion2D posicion) {
        return posicion.esLaMismaQue(posicion);
    }
}


