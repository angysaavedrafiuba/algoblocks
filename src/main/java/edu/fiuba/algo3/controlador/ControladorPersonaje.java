package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Posicion2D;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControladorPersonaje implements PropertyChangeListener {
    Posicion2D posicion;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.posicion = (Posicion2D) evt.getNewValue();
    }
}
