package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDibujo;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class VistaDibujo extends Pane {
    ControladorDibujo controladorDibujo;
    Canvas canvas;
    GraphicsContext gc;

    public VistaDibujo(Rectangle2D screenBounds) {
        super();
        controladorDibujo = new ControladorDibujo(screenBounds, this);
        Algoblocks.getInstance().getDibujo().addPropertyChangeListener(controladorDibujo);
        canvas = controladorDibujo.generarCanvas();
        super.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.web("#654062"));
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

    public void reset() {
        gc.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
    }
}
