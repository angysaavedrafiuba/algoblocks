package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.BotonResetHandler;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonReset extends ImagenConComportamiento {
    public BotonReset(Rectangle2D screenBounds, Scene scene, double proporcion) {
        super("reset.png", screenBounds, scene);

        setOnAction(new BotonResetHandler());
        super.ajustarTamanio(screenBounds, proporcion);

    }
}
