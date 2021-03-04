package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorBloqueCompuesto extends HBox {
    VistaBloquesAgregados vistaBloquesAgregados;

    public ContenedorBloqueCompuesto(Scene scene, Rectangle2D bounds, BloqueAgregable bloque){
        vistaBloquesAgregados = new VistaBloquesAgregados(bounds, scene);
        super.getChildren().add(new VBox());
        super.getChildren().add(new PanelDeBloques(bounds, scene, bloque.getRecorrido()));
    }
}
