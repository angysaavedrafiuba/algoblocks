package edu.fiuba.algo3.vista;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        ContenedorPrincipalJuego juego = new ContenedorPrincipalJuego();

        Scene escenaJuego   = new Scene(juego,  screenBounds.getWidth(),    screenBounds.getHeight());
        ContenedorInicial inicioJuego = new ContenedorInicial(stage, escenaJuego);
        juego.setEscena(escenaJuego);
        juego.inicializar(screenBounds);

        stage.setTitle("AlgoBlocks");

        Scene pantallaInicio = new Scene(inicioJuego,900,500);

        stage.getIcons().add(new Image("pencil.png"));
        stage.setScene(pantallaInicio);
        stage.setFullScreen(false);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}