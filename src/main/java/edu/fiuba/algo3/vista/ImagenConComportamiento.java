package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HoverHandlerCursorADefault;
import edu.fiuba.algo3.controlador.HoverHandlerCursorAPuntero;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ImagenConComportamiento extends Pane {

    ImageView imgView = new ImageView();

    public ImagenConComportamiento(String nombreImagen, Rectangle2D screenBounds, Scene scene) {
        super();
        super.setPrefHeight(screenBounds.getHeight() * 0.15);
        super.setPadding(new Insets(0, 0, 0, 0));

        String URLImagen = getClass().getClassLoader().getResource(nombreImagen).toExternalForm();
        Image img = new Image(URLImagen);
        this.imgView.setImage(img);
        this.ajustarTamanio(screenBounds);

        this.setOnMouseEntered(new HoverHandlerCursorAPuntero(scene));
        this.setOnMouseExited(new HoverHandlerCursorADefault(scene));

        super.getChildren().add(this.imgView);
    }

    private void ajustarTamanio(Rectangle2D screenBounds) {
        double alto = this.imgView.getFitHeight();
        double ancho = this.imgView.getFitWidth();
        double relacion = ancho/alto;

        this.imgView.setFitWidth(screenBounds.getHeight() * 0.085 * relacion);
        this.imgView.setFitHeight(screenBounds.getHeight() * 0.085);
    }
}
