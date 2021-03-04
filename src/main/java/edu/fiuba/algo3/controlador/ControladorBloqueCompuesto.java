package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ContenedorBloqueCompuesto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorBloqueCompuesto extends SonidoClickBloque implements EventHandler {
    ContenedorBloqueCompuesto vistaBloque;
    BloqueAgregable bloque;
    Scene escena;

    public ControladorBloqueCompuesto(BloqueAgregable bloque) {
        Rectangle2D bounds = new Rectangle2D(0, 0, 900, 600);
        HBox bloquesAgregados = new ContenedorBloqueCompuesto(escena, bounds, bloque);
        Pane paneGeneral = new Pane(bloquesAgregados);
        this.escena = new Scene(paneGeneral, 900, 600);
        vistaBloque = new ContenedorBloqueCompuesto(this.escena, new Rectangle2D(700, 450, 0, 0), bloque);
    }

    @Override
    public void handle(Event event) {
        Stage stage = new Stage();

        stage.setScene(this.escena);
        stage.setResizable(false);
        stage.show();
    }
}
