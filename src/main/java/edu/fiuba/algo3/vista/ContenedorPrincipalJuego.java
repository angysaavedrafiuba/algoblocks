package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipalJuego extends BorderPane {
    Scene scene;
    private Algoblocks algoblocks;

    public ContenedorPrincipalJuego(){
        super();
        this.algoblocks = Algoblocks.getInstance();
    }

    public void setEscena(Scene escenaJuego) {
        this.scene = escenaJuego;
    }

    public void inicializar(Rectangle2D screenBounds) {
        super.setTop(new PanelAlgoritmo(screenBounds, scene, this.algoblocks));
        super.setLeft(new PanelDeBloques(screenBounds, scene, this.algoblocks));
        super.setCenter(new Tablero(screenBounds, this.algoblocks));
    }
}
