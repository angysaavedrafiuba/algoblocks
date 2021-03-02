package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.listeners.ControladorDibujo;
import edu.fiuba.algo3.listeners.ControladorPersonaje;
import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.Posicion2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaDibujo extends Pane {
    ControladorDibujo controladorDibujo;
    Algoblocks algoblocks = Algoblocks.getInstance();
    Canvas canvas;
    GraphicsContext gc;
    double xMax;
    double yMax;

    public VistaDibujo(Rectangle2D screenBounds) {
        super();
        controladorDibujo = new ControladorDibujo(screenBounds, this);
        algoblocks.addPropertyChangeListenerADibujo(controladorDibujo);
        xMax = screenBounds.getWidth() * 0.8; //TODO refactorizar este hardcodeo
        yMax = screenBounds.getHeight() * 0.8;
        canvas = new Canvas(xMax, yMax);
        super.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.CORAL.brighter());
        gc.setLineWidth(5);
    }

    public void update(Posicion2D anteultimaPosicionDibujada, Posicion2D posicionDibujada, Posicion2D ultimaPosicionPersonaje) {
        double ultimaXdePersonaje = transformarX(ultimaPosicionPersonaje.getX());
        double ultimaYdePersonaje = transformarY(ultimaPosicionPersonaje.getY());
        double xPosicionDibujada = transformarX(posicionDibujada.getX());
        double yPosicionDibujada = transformarY(posicionDibujada.getY());
        if(!anteultimaPosicionDibujada.esLaMismaQue(ultimaPosicionPersonaje) ||
                (anteultimaPosicionDibujada.esLimite() && posicionDibujada.esLimite())) {
        } else {
            gc.beginPath();
            gc.moveTo(ultimaXdePersonaje, ultimaYdePersonaje);
            gc.lineTo(xPosicionDibujada, yPosicionDibujada);
            gc.stroke();
            gc.closePath();
        }
    }

    private double transformarX(int x) {
        return (xMax/Posicion2D.xLimite)*x;
    }

    private double transformarY(int y) {
        return yMax - (yMax/Posicion2D.yLimite)*y;
    }

    public ControladorDibujo getControladorDibujo() {
        return controladorDibujo;
    }
}
