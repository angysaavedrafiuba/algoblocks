package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPlayHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonPlay extends ImagenConComportamiento {

    public BotonPlay(Rectangle2D screenBounds, Scene scene) {
        super("play-button.png", screenBounds, scene);
        super.setOnAction(new BotonPlayHandler());
        super.ajustarTamanio(screenBounds, 0.06);
    }
}
