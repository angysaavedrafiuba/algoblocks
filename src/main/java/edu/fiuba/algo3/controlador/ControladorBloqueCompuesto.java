package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ContenedorBloqueCompuesto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorBloqueCompuesto extends SonidoClickBloque implements EventHandler {
    ContenedorBloqueCompuesto vistaBloque;
    BloqueAgregable bloque;

    public ControladorBloqueCompuesto(BloqueAgregable bloque) {
        vistaBloque = new ContenedorBloqueCompuesto();
        this.bloque = bloque;
    }

    @Override
    public void handle(Event event) {
        BorderPane pane = new BorderPane();
        Stage stageAyuda = new Stage();
        HBox scrollBox = new HBox();
        ScrollPane test = new ScrollPane(scrollBox);

        Scene escena = new Scene(pane, 700, 450);
        stageAyuda.setScene(escena);
        stageAyuda.show();
    }
}
