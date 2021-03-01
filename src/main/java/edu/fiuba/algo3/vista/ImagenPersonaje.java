package edu.fiuba.algo3.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenPersonaje extends ImageView {

    private final String URL_PERSONAJE_DERECHA   =  "character-east.png";
    private final String URL_PERSONAJE_IZQUIERDA =  "character-west.png";
    private final String URL_PERSONAJE_ARRIBA    =  "character-north.png";
    private final String URL_PERSONAJE_ABAJO     =  "character-south.png";

    ImagenPersonaje(){
        super();
        String urlImagen = getClass().getClassLoader().getResource(URL_PERSONAJE_DERECHA).toExternalForm();
        Image personaje = new Image(urlImagen);
        super.setImage(personaje);
    }
}
