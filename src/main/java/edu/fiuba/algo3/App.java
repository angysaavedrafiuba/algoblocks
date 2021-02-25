package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        URL url = getClass().getClassLoader().getResource("inicio.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(url));
        Scene scene = new Scene(root, 640, 440);
        stage.setTitle("AlgoBlocks");
        stage.setScene(scene);
        stage.show();

        /*
        ContenedorJuego pane = new ContenedorJuego();
        Scene scene = new Scene(pane, 900,500);
        Inicializar inicioJuego = new Inicializar(stage, scene);

        Scene pantallaInicio = new Scene(inicioJuego,900,500);
        stage.setScene(pantallaInicio);
        stage.show();
        */

    }

    public static void main(String[] args) {
        launch();
    }

}