package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.BloqueDeAccion;
import edu.fiuba.algo3.modelo.MoverALaDerecha;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelDeBloques extends VBox {

    Scene scene;

    PanelDeBloques(Rectangle2D screenBounds, Scene scene, Algoblocks algoblocks){
        super();
        this.scene = scene;
        super.setPrefWidth(screenBounds.getWidth() * 0.20);
        super.setPadding(new Insets(0, 0 ,0, screenBounds.getWidth() * 0.02));
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setAlignment(Pos.CENTER);
        super.getChildren().add(new ImagenConComportamiento("draw-north.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaArriba()));
        super.getChildren().add(new ImagenConComportamiento("draw-south.png",   screenBounds, this.scene, new ControladorBloqueMoverHaciaAbajo()));
        super.getChildren().add(new ImagenConComportamiento("draw-east.png",    screenBounds, this.scene, new ControladorBloqueMoverADerecha()));
        super.getChildren().add(new ImagenConComportamiento("draw-west.png",    screenBounds, this.scene, new ControladorBloqueMoverAIzquierda()));
        super.getChildren().add(new ImagenConComportamiento("bajar.png",        screenBounds, this.scene, new ControladorBloqueBajar()));
        super.getChildren().add(new ImagenConComportamiento("subir.png",        screenBounds, this.scene, new ControladorBloqueSubir()));
        super.getChildren().add(new ImagenConComportamiento("invertir.png",     screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("repeticion.png",   screenBounds, this.scene));
    }
}
