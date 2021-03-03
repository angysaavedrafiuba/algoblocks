package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonTachoHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonTacho extends ImagenConComportamiento {
    public BotonTacho(Rectangle2D screenBounds, Scene scene) {
        super("canopen.png", screenBounds, scene);
        super.setOnAction(new BotonTachoHandler());
    }
}
