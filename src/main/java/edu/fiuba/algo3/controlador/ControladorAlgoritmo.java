package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ControladorAlgoritmo implements PropertyChangeListener {
    ArrayList<Bloque> bloques = new ArrayList<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.bloques = (ArrayList<Bloque>) evt.getNewValue();
    }
}
