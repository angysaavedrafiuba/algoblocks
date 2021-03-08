package edu.fiuba.algo3.vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

public class ImagenBloqueEnAlgoritmo extends ImagenConComportamiento {
    public ImagenBloqueEnAlgoritmo(String imagen, Rectangle2D bounds, Scene scene) {
        super(imagen, bounds, scene);
        ajustarTamanio(bounds, 0.08);
    }
}
