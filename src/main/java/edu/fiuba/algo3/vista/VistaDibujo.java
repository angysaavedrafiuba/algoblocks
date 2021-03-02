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
        gc.setStroke(Color.CORAL.brighter());
        gc.setLineWidth(5);
    }

    public void update(ArrayList<Posicion2D> posicionesDibujadas) {
        System.out.println("Me estoy actualizando");
        gc.moveTo(Posicion2D.xLimite/2, Posicion2D.yLimite/2);
        gc.beginPath();
        posicionesDibujadas.forEach(posicion2D -> {
            double nuevoX = transformarX(posicion2D.getX());
            double nuevoY = transformarY(posicion2D.getY());
            System.out.println("canvas a " + posicion2D.getX() + ", " + posicion2D.getY());
            gc.lineTo(nuevoX, nuevoY);
            gc.stroke();
        });
        gc.closePath();
        //TODO: arreglar la posicion inicial para que coincida con la punta del lapiz del personaje
    }

    private double transformarX(int x) {
        return (xMax/Posicion2D.xLimite)*x;
    }

    private double transformarY(int y) {
        return (yMax/Posicion2D.yLimite)*y;
    }

}
