package edu.fiuba.algo3.listeners;

import edu.fiuba.algo3.modelo.Posicion2D;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ControladorDibujo implements PropertyChangeListener {
    ArrayList<Posicion2D> posicionesDibujadas = new ArrayList<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.posicionesDibujadas = (ArrayList<Posicion2D>) evt.getNewValue();
    }
}
