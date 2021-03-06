package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDibujo;
import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenPersonaje extends ImageView {
    final VistaPersonaje vistaPersonaje;

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
