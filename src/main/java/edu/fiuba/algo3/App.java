package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.BotonEntrar;
import edu.fiuba.algo3.controlador.ControladorDeJuego;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        FXMLLoader loaderJuego  = new FXMLLoader(getClass().getClassLoader().getResource("juego2.fxml"));

        Parent inicio   = loaderInicio.load();
        Parent juego    = loaderJuego.load();

        Scene escenaInicio  = new Scene(inicio, 640,440);
        Scene escenaJuego   = new Scene(juego, 640, 440);

        ControladorDeJuego controladorPrincipal = loaderJuego.getController();
        controladorPrincipal.init(escenaJuego);

        stage.setTitle("AlgoBlocks");

        BotonEntrar entrarEventHandler = loaderInicio.getController();
        entrarEventHandler.init(stage, escenaJuego);

        stage.setScene(escenaInicio);
        stage.setFullScreen(true);
        //stage.setResizable(true);
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