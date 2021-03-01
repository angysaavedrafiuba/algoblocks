package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.listeners.ControladorPersonaje;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.concurrent.RecursiveTask;

public class ImagenPersonaje extends ImageView {

    private final String URL_PERSONAJE_DERECHA   =  "character-east.png";
    private final String URL_PERSONAJE_IZQUIERDA =  "character-west.png";
    private final String URL_PERSONAJE_ARRIBA    =  "character-north.png";
    private final String URL_PERSONAJE_ABAJO     =  "character-south.png";

    Algoblocks algoblocks = Algoblocks.getInstance();
    ControladorPersonaje controladorPersonaje;


    ImagenPersonaje(Rectangle2D screenBounds){
        super();
        String urlImagen = getClass().getClassLoader().getResource(URL_PERSONAJE_DERECHA).toExternalForm();
        Image personaje = new Image(urlImagen);
        controladorPersonaje = new ControladorPersonaje(screenBounds, this);


        algoblocks.addPropertyChangeListenerAlPersonaje(controladorPersonaje);
        super.setImage(personaje);

        this.setLayoutX(controladorPersonaje.getX());
        this.setLayoutY(controladorPersonaje.getY());
    }

    public void update(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
