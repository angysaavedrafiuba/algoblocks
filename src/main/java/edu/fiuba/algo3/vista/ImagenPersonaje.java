package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenPersonaje extends ImageView {

    private final String URL_PERSONAJE_DERECHA   =  "character-east.png";
    private final String URL_PERSONAJE_IZQUIERDA =  "character-west.png";
    private final String URL_PERSONAJE_ARRIBA    =  "character-north.png";
    private final String URL_PERSONAJE_ABAJO     =  "character-south.png";

    VistaPersonaje vistaPersonaje;

    ImagenPersonaje(Rectangle2D screenBounds, ControladorDibujo controladorDibujo){
        super();
        String urlImagen = getClass().getClassLoader().getResource("small_static_avatar.png").toExternalForm();
        Image personaje = new Image(urlImagen);

        vistaPersonaje = new VistaPersonaje(screenBounds, this, controladorDibujo);
        Algoblocks.getInstance().getPersonaje().addPropertyChangeListener(vistaPersonaje);

        super.setImage(personaje);

        this.setLayoutX(vistaPersonaje.getX());
        this.setLayoutY(vistaPersonaje.getY());
    }

    public void update(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
