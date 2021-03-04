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

        this.setOnMouseEntered(new HoverHandlerCursorAPuntero(scene));
        this.setOnMouseExited(new HoverHandlerCursorADefault(scene));

        super.getChildren().add(this.imgView);
    }

    public ImagenConComportamiento(String nombreImagen, Rectangle2D screenBounds, Scene scene, EventHandler controlador) {
        super();
        super.setPrefHeight(screenBounds.getHeight() * 0.15);
        super.setPadding(new Insets(20, 0, 50, 10));

        String URLImagen = getClass().getClassLoader().getResource(nombreImagen).toExternalForm();
        Image img = new Image(URLImagen);
        this.imgView.setImage(img);

        this.setOnMouseEntered(new HoverHandlerCursorAPuntero(scene));
        this.setOnMouseExited(new HoverHandlerCursorADefault(scene));

        super.getChildren().add(this.imgView);
        super.setOnMouseClicked(controlador);
    }

    protected void ajustarTamanio(Rectangle2D screenBounds, double proporcion) {
        double alto = this.imgView.getImage().getHeight();
        double ancho = this.imgView.getImage().getWidth();
        double relacion = ancho/alto;
        System.out.println();
        this.imgView.setFitWidth(screenBounds.getHeight() * proporcion * relacion);
        this.imgView.setFitHeight(screenBounds.getWidth() * proporcion);
    }

    public void setOnAction(EventHandler eventHandler) {
        super.setOnMouseClicked(eventHandler);
    }
}
