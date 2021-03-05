package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.event.EventHandler;
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
        super.setPadding(new Insets(10, 10, 10, 10));

        String URLImagen = getClass().getClassLoader().getResource(nombreImagen).toExternalForm();
        Image img = new Image(URLImagen);
        this.imgView.setImage(img);

        this.imgView.setOnMouseEntered(new HoverHandlerCursorAPuntero(scene));
        this.imgView.setOnMouseExited(new HoverHandlerCursorADefault(scene));

        super.getChildren().add(this.imgView);
    }


    protected void ajustarTamanio(Rectangle2D screenBounds, double proporcion) {
        double alto = this.imgView.getImage().getHeight();
        double ancho = this.imgView.getImage().getWidth();
        double relacion = ancho/alto;
        this.imgView.setFitWidth(screenBounds.getHeight() * proporcion * relacion * 1.3);
        this.imgView.setFitHeight(screenBounds.getHeight() * proporcion * 1.4);
    }

    public void setOnAction(EventHandler eventHandler) {
        this.imgView.setOnMouseClicked(eventHandler);
    }
}
