package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ContenedorBloqueCompuesto;
import edu.fiuba.algo3.vista.ImagenBloqueEnAlgoritmo;
import edu.fiuba.algo3.vista.MapeoDeBloques;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControladorBloqueCompuesto extends SonidoClickBloque implements EventHandler, PropertyChangeListener {
    ContenedorBloqueCompuesto vistaBloque;
    Bloque bloque;
    Scene escena;
    Rectangle2D bounds;

    public ControladorBloqueCompuesto(BloqueAgregable bloque) {
        bloque.addPropertyChangeListener(this);
        this.bounds = new Rectangle2D(0, 0, 900, 600);

        this.vistaBloque = new ContenedorBloqueCompuesto();
        Pane paneGeneral = new Pane(this.vistaBloque);

        this.escena = new Scene(paneGeneral, 900,600);
        this.vistaBloque.inicializar(this.bounds, this.escena, bloque);
    }

    @Override
    public void handle(Event event) {
        Stage stage = new Stage();
        stage.setTitle("Bloque compuesto");
        stage.setScene(this.escena);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.bloque = (Bloque) evt.getNewValue();
        this.vistaBloque.update(this.bloque);
    }
}
