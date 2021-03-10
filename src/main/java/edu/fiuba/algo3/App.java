package edu.fiuba.algo3;
import edu.fiuba.algo3.vista.ContenedorInicial;
import edu.fiuba.algo3.vista.ContenedorPrincipalJuego;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;

import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        ContenedorPrincipalJuego juego = new ContenedorPrincipalJuego();

        Scene escenaJuego   = new Scene(juego,  screenBounds.getWidth(),    screenBounds.getHeight());
        ContenedorInicial inicioJuego = new ContenedorInicial(stage, escenaJuego);
        juego.setEscena(escenaJuego);
        juego.inicializar(screenBounds);

        stage.setTitle("AlgoBlocks");

        Scene pantallaInicio = new Scene(inicioJuego,900,500);
        stage.setScene(pantallaInicio);
        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}