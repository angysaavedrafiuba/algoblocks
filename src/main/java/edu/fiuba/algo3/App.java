package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        ContenedorJuego pane = new ContenedorJuego();
        Scene scene = new Scene(pane, 900,500);
        Inicializar inicioJuego = new Inicializar(stage, scene);

        Scene pantallaInicio = new Scene(inicioJuego,900,500);

        stage.setScene(pantallaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}