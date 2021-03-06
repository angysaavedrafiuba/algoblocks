package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

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
        super.setLeft(new PanelDeBloques(screenBounds, scene, Algoblocks.getInstance().getRecorridoNormal()));
        super.setCenter(new Tablero(screenBounds));
    }
}
