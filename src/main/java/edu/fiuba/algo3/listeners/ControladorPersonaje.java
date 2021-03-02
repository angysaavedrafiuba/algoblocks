package edu.fiuba.algo3.listeners;

import edu.fiuba.algo3.modelo.Posicion2D;
import edu.fiuba.algo3.vista.ImagenPersonaje;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

public class ControladorPersonaje implements PropertyChangeListener {
    private final ImagenPersonaje vista;
    Posicion2D posicion;
    double xMax;
    double yMax;
    ControladorDibujo controladorDibujo;

    public ControladorPersonaje(Rectangle2D screenBounds, ImagenPersonaje vista, ControladorDibujo controladorDibujo) {
        this.posicion = Posicion2D.posicionInicial();
        this.controladorDibujo = controladorDibujo;
        xMax = screenBounds.getWidth() * 0.8;
        yMax = screenBounds.getHeight() * 0.8;

        //TODO eliminar el hardcodeo de 0.8

        this.vista = vista;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controladorDibujo.informarUltimaPosicion((Posicion2D) evt.getOldValue());
        this.posicion = (Posicion2D) evt.getNewValue();
        this.vista.update(this.getX(), this.getY());
    }

    public double getX(){
        return ((xMax/Posicion2D.xLimite)*posicion.getX() - 70);
    }

    public double getY(){
        return yMax - ((yMax/Posicion2D.yLimite)*posicion.getY() + 100);
    }
}
