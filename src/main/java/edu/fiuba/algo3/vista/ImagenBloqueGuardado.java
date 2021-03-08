package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBloquePersonalizado;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.modelo.RecorridoNormal;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.awt.datatransfer.FlavorEvent;

public class ImagenBloqueGuardado extends VBox {
    ImagenBloque imagen;
    String nombreAlgoritmo;

    ImagenBloqueGuardado(String nombre, Rectangle2D screenBounds, Scene scene, RecorridoNormal recorrido, BloqueAgregable bloque) {
        this.nombreAlgoritmo = nombre;
        this.imagen = new ImagenBloque("guardado.png", screenBounds, scene, new ControladorBloquePersonalizado(recorrido, bloque));

        Label labelAlgoritmo = new Label();
        labelAlgoritmo.setText(this.nombreAlgoritmo);
        labelAlgoritmo.setFont(new Font(20));
        labelAlgoritmo.setPadding(new Insets(screenBounds.getHeight() * 0.1, 0, 0, screenBounds.getWidth()*0.09));

        this.setStyle("-fx-background-color: " + Colores.NARANJA + ";");
        this.getChildren().addAll(new Label(this.nombreAlgoritmo), this.imagen);
    }
}
