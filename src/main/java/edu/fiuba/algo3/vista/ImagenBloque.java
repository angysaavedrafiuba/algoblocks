package edu.fiuba.algo3.vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import javafx.event.EventHandler;

public class ImagenBloque extends ImagenConComportamiento{

    ImagenBloque(String nombreImagen, Rectangle2D screenBounds, Scene scene, EventHandler handler){
        super(nombreImagen, screenBounds, scene);
        super.setOnAction(handler);
        ajustarTamanio(screenBounds, 0.08);
    }
}
