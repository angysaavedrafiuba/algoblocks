package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.listeners.ControladorDibujo;
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
        gc.beginPath();
        gc.setStroke(Color.BLACK.brighter());
        gc.setLineWidth(5);
        gc.moveTo(xMax/2, yMax/2);
    }

    public void update(ArrayList<Posicion2D> posicionesDibujadas) {
        posicionesDibujadas.forEach(posicion2D -> {
            double nuevoX = transformarX(posicion2D.getX());
            double nuevoY = transformarY(posicion2D.getY());
            gc.moveTo(nuevoX, nuevoY);
        });
        gc.stroke();
    }

    private double transformarX(int x) {
        return (xMax/Posicion2D.xLimite)*x;
    }

    private double transformarY(int y) {
        return (yMax/Posicion2D.yLimite)*y;
    }

}
