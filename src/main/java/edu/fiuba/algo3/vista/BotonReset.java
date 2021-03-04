package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonReiniciarHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonReset extends ImagenConComportamiento {
    public BotonReset(Rectangle2D screenBounds, Scene scene) {
        super("loopArrow.png", screenBounds, scene);
        setOnAction(new BotonReiniciarHandler());
        super.ajustarTamanio(screenBounds, 0.06);
    }
}
