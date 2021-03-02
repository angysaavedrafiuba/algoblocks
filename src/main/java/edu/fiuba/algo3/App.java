package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonEntrar;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ContenedorPrincipalJuego;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.fxml.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loaderInicio = new FXMLLoader(getClass().getClassLoader().getResource("inicio.fxml"));

        Algoblocks.Create();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        Parent inicio   = loaderInicio.load();
        ContenedorPrincipalJuego juego = new ContenedorPrincipalJuego();

        Scene escenaInicio  = new Scene(inicio, screenBounds.getWidth(),    screenBounds.getHeight());
        Scene escenaJuego   = new Scene(juego,  screenBounds.getWidth(),    screenBounds.getHeight());

        juego.setEscena(escenaJuego);
        juego.inicializar(screenBounds);

        stage.setTitle("AlgoBlocks");

        BotonEntrar entrarEventHandler = loaderInicio.getController();
        entrarEventHandler.init(stage, escenaJuego);

        stage.setScene(escenaInicio);
        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}