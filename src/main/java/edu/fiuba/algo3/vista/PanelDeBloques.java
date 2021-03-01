package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelDeBloques extends VBox {

    Scene scene;

    PanelDeBloques(Rectangle2D screenBounds, Scene scene){
        super();
        this.scene = scene;
        super.setPrefWidth(screenBounds.getWidth() * 0.15);
        super.setPadding(new Insets(0, 0 ,0, screenBounds.getWidth() * 0.02));
        super.setStyle("-fx-background-color: #ff2e63;");
        super.setAlignment(Pos.CENTER);
        super.getChildren().add(new ImagenConComportamiento("draw-north.png",   screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("draw-south.png",   screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("draw-east.png",    screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("draw-west.png",    screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("bajar.png",        screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("subir.png",        screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("invertir.png",     screenBounds, this.scene));
        super.getChildren().add(new ImagenConComportamiento("repeticion.png",   screenBounds, this.scene));
    }
}
