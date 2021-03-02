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
    Posicion2D ultimaPosicionPersonaje;
    Posicion2D ultimaPosicionDibujada;

    public ControladorDibujo(Rectangle2D screenBounds, VistaDibujo vista) {
        this.vista = vista;
        this.ultimaPosicionPersonaje = Posicion2D.posicionInicial();
        this.ultimaPosicionDibujada = Posicion2D.posicionInicial();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Posicion2D posicionDibujada = (Posicion2D) evt.getNewValue();
        this.vista.update(ultimaPosicionDibujada, posicionDibujada, ultimaPosicionPersonaje);
        ultimaPosicionDibujada = posicionDibujada;
    }

    public void informarUltimaPosicion(Posicion2D posicion) {
        this.ultimaPosicionPersonaje = posicion;
    }
}
