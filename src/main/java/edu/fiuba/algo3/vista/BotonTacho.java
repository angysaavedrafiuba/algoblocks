package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonTachoHandler;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonTacho extends ImagenConComportamiento {
    public BotonTacho(Rectangle2D screenBounds, Scene scene, BloqueAgregable bloque, double proporcion) {
        super("canopen.png", screenBounds, scene);

        super.setOnAction(new BotonTachoHandler(bloque));
        super.ajustarTamanio(screenBounds, proporcion);
    }

    public BotonTacho(Rectangle2D screenBounds, Scene scene, double proporcion) {
        super("canopen.png", screenBounds, scene);

        super.setOnAction(new BotonTachoHandler());
        super.ajustarTamanio(screenBounds, proporcion);
    }
}
