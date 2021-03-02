package edu.fiuba.algo3.listeners;

import edu.fiuba.algo3.modelo.Posicion2D;
import edu.fiuba.algo3.vista.Tablero;
import edu.fiuba.algo3.vista.VistaDibujo;
import javafx.geometry.Rectangle2D;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ControladorDibujo implements PropertyChangeListener {
    private final VistaDibujo vista;
    ArrayList<Posicion2D> posicionesDibujadas;

    public ControladorDibujo(Rectangle2D screenBounds, VistaDibujo vista) {
        this.vista = vista;
        this.posicionesDibujadas = new ArrayList<>();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.posicionesDibujadas = (ArrayList<Posicion2D>) evt.getNewValue();
        this.vista.update(posicionesDibujadas);
    }
}
