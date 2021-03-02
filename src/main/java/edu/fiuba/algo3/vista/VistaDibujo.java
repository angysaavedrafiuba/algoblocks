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

    public VistaDibujo(Rectangle2D screenBounds) {
        super();
        controladorDibujo = new ControladorDibujo(screenBounds, this);
        algoblocks.addPropertyChangeListenerADibujo(controladorDibujo);
        canvas = controladorDibujo.generarCanvas();
        super.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.CORAL.brighter());
        gc.setLineWidth(5);
    }

    public void update(double ultimaXPersonaje, double ultimaYPersonaje, double xPosicionDibujada, double yPosicionDibujada) {
        gc.beginPath();
        gc.moveTo(ultimaXPersonaje, ultimaYPersonaje);
        gc.lineTo(xPosicionDibujada, yPosicionDibujada);
        gc.stroke();
        gc.closePath();
    }

    public ControladorDibujo getControladorDibujo() {
        return controladorDibujo;
    }
}
