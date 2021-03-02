package edu.fiuba.algo3.listeners;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.vista.PanelAlgoritmo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ControladorAlgoritmo implements PropertyChangeListener {
    ArrayList<Bloque> bloques = new ArrayList<>();
    PanelAlgoritmo vista;

    public ControladorAlgoritmo(PanelAlgoritmo vista){
        this.vista = vista;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.bloques = (ArrayList<Bloque>) evt.getNewValue();
        this.vista.update(bloques);
    }
}
