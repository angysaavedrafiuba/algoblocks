package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.vista.PanelAlgoritmo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VistaAlgoritmo implements PropertyChangeListener {
    Bloque ultimoBloque;
    final PanelAlgoritmo vista;

    public VistaAlgoritmo(PanelAlgoritmo vista){
        this.vista = vista;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.ultimoBloque = (Bloque) evt.getNewValue();
        this.vista.update(this.ultimoBloque);
    }
}
