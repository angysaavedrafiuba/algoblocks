package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonAyudaHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonAyuda extends ImagenConComportamiento {

    public BotonAyuda(Rectangle2D screenBounds, Scene scene) {
        super("ayuda-icono.png", screenBounds, scene);
        super.setOnAction(new BotonAyudaHandler());
        super.ajustarTamanio(screenBounds, 0.06);
    }
}
