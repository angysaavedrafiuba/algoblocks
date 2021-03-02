package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.listeners.ControladorDibujo;
import edu.fiuba.algo3.listeners.ControladorPersonaje;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenPersonaje extends ImageView {

    private final String URL_PERSONAJE_DERECHA   =  "character-east.png";
    private final String URL_PERSONAJE_IZQUIERDA =  "character-west.png";
    private final String URL_PERSONAJE_ARRIBA    =  "character-north.png";
    private final String URL_PERSONAJE_ABAJO     =  "character-south.png";

    Algoblocks algoblocks = Algoblocks.getInstance();
    ControladorPersonaje controladorPersonaje;

    ImagenPersonaje(Rectangle2D screenBounds, ControladorDibujo controladorDibujo){
        super();
        String urlImagen = getClass().getClassLoader().getResource(URL_PERSONAJE_DERECHA).toExternalForm();
        Image personaje = new Image(urlImagen);
        controladorPersonaje = new ControladorPersonaje(screenBounds, this, controladorDibujo);

        algoblocks.addPropertyChangeListenerAlPersonaje(controladorPersonaje);
        super.setImage(personaje);

        this.setLayoutX(controladorPersonaje.getX());
        this.setLayoutY(controladorPersonaje.getY());
    }

    public void update(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public ControladorPersonaje getControladorPersonaje() {
        return controladorPersonaje;
    }
}
