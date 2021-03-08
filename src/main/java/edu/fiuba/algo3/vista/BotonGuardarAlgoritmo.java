package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonGuardarHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class BotonGuardarAlgoritmo extends ImagenConComportamiento {

    public BotonGuardarAlgoritmo(Rectangle2D screenBounds, Scene scene, double proporcion, PanelAlgoritmo panel) {
        super("guardar.png", screenBounds, scene);
        super.setOnAction(new BotonGuardarHandler(panel));
        super.ajustarTamanio(screenBounds, proporcion);
    }
}