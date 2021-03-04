package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

import java.awt.*;
import java.io.File;

public class BotonAyudaHandler implements EventHandler<MouseEvent> {

    public BotonAyudaHandler() {}

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stageAyuda = new Stage();
        VBox box = new VBox();
        ScrollPane test = new ScrollPane(box);
        Image img = new Image(getClass().getClassLoader().getResource("ayuda.png").toExternalForm());
        ImageView imgView = new ImageView(img);

        imgView.fitWidthProperty().bind(stageAyuda.widthProperty());
        imgView.fitHeightProperty().bind(stageAyuda.heightProperty());

        box.getChildren().add(imgView);

        Scene escenaAyuda = new Scene(test, 700, 450);
        stageAyuda.setScene(escenaAyuda);
        stageAyuda.show();
    }
}
