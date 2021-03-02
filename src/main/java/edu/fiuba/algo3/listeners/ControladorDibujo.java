package edu.fiuba.algo3.listeners;

import edu.fiuba.algo3.modelo.Posicion2D;
import edu.fiuba.algo3.vista.Tablero;
import edu.fiuba.algo3.vista.VistaDibujo;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ControladorDibujo implements PropertyChangeListener {
    private final VistaDibujo vista;
    Posicion2D ultimaPosicionPersonaje;
    Posicion2D ultimaPosicionDibujada;
    double xMax;
    double yMax;

    public ControladorDibujo(Rectangle2D screenBounds, VistaDibujo vista) {
        this.vista = vista;
        this.ultimaPosicionPersonaje = Posicion2D.posicionInicial();
        this.ultimaPosicionDibujada = Posicion2D.posicionInicial();
        xMax = screenBounds.getWidth() * 0.8;
        yMax = screenBounds.getHeight() * 0.8;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Posicion2D posicionDibujada = (Posicion2D) evt.getNewValue();
        double ultimaXdePersonaje = transformarX(ultimaPosicionPersonaje.getX());
        double ultimaYdePersonaje = transformarY(ultimaPosicionPersonaje.getY());
        double xPosicionDibujada = transformarX(posicionDibujada.getX());
        double yPosicionDibujada = transformarY(posicionDibujada.getY());
        if(!ultimaPosicionDibujada.esLaMismaQue(ultimaPosicionPersonaje) ||
                (ultimaPosicionDibujada.esLimite() && posicionDibujada.esLimite())) {
        } else {
            vista.update(ultimaXdePersonaje, ultimaYdePersonaje, xPosicionDibujada, yPosicionDibujada);
        }

        ultimaPosicionDibujada = posicionDibujada;
    }

    public void informarUltimaPosicion(Posicion2D posicion) {
        this.ultimaPosicionPersonaje = posicion;
    }

    public Canvas generarCanvas() {
        return new Canvas(xMax, yMax);
    }

    private double transformarX(int x) {
        return (xMax/Posicion2D.xLimite)*x;
    }

    private double transformarY(int y) {
        return yMax - (yMax/Posicion2D.yLimite)*y;
    }
}
