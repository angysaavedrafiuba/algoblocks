package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Dibujo {
    private ArrayList<Posicion2D> posicionesDibujadas = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void dibujar(Posicion2D posicionADibujar) {
        posicionesDibujadas.add(posicionADibujar.clonarPosicion());
        support.firePropertyChange("ultimaPosicionPersonaje", null, (Posicion2D) posicionesDibujadas.get(posicionesDibujadas.size() - 1));
    }

    public void dibujarConLapiz(Posicion2D posicionADibujar, Lapiz lapiz) {
        lapiz.dibujar(this, posicionADibujar);
    }

    public void reiniciar() {
        posicionesDibujadas = new ArrayList<>();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /* Test only */
    public boolean enBlanco() {
        return(posicionesDibujadas.isEmpty());
    }

    public boolean estaDibujada(Posicion2D posicionAVerificar) {
        return posicionesDibujadas.stream().anyMatch(pos -> pos.esLaMismaQue(posicionAVerificar));
    }

    public ArrayList<Posicion2D> posicionesDibujadas() {
        return posicionesDibujadas;
    }
}
