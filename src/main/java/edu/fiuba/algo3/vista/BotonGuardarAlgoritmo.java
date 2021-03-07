package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonGuardarHandler;
import edu.fiuba.algo3.controlador.BotonPlayHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonGuardarAlgoritmo extends ImagenConComportamiento {

    public BotonGuardarAlgoritmo(Rectangle2D screenBounds, Scene scene) {
        super("guardar.png", screenBounds, scene);
        super.setOnAction(new BotonGuardarHandler());
        super.ajustarTamanio(screenBounds, 0.06);
    }
}