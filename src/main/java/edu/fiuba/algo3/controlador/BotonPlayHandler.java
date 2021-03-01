package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonPlayHandler implements EventHandler<MouseEvent> {


    private final Algoblocks algoblocks;

    public BotonPlayHandler(){
        this.algoblocks = Algoblocks.getInstance();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.algoblocks.ejecutar();
    }
}
