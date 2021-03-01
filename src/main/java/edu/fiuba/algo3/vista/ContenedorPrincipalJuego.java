package edu.fiuba.algo3.vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipalJuego extends BorderPane {
    Scene scene;

    public ContenedorPrincipalJuego(){
        super();
    }

    public void setEscena(Scene escenaJuego) {
        this.scene = escenaJuego;
    }

    public void inicializar(Rectangle2D screenBounds) {
        super.setTop(new PanelAlgoritmo(screenBounds, scene));
        super.setLeft(new PanelDeBloques(screenBounds, scene));
        super.setCenter(new Tablero(screenBounds));
    }
}
