package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import edu.fiuba.algo3.modelo.BloqueAgregable;
import edu.fiuba.algo3.vista.AgregadorBloques;
import edu.fiuba.algo3.vista.MapeoDeBloques;
import edu.fiuba.algo3.vista.PanelAlgoritmo;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonGuardarHandler implements EventHandler {
    PanelAlgoritmo panelAlgoritmo;
    String nombre;

    public BotonGuardarHandler(PanelAlgoritmo panel) {
        panelAlgoritmo = panel;
    }

    @Override
    public void handle(Event event) {
        if(panelAlgoritmo.getCantidadBloques() > 0) {

            VBox principal = new VBox();
            Scene escena = new Scene(principal);
            Stage pedirInput = new Stage();

            TextArea areaTexto = new TextArea();
            areaTexto.setPrefRowCount(1);
            Label labelTexto = new Label("Ingrese un nombre para el algoritmo");
            Button ingresar = new Button("Guardar");
            ingresar.setOnAction(e -> {
                nombre = areaTexto.getText();
                pedirInput.close();
                BloqueAgregable nuevoPersonalizado = Algoblocks.getInstance().guardarAlgoritmo(nombre);
                Algoblocks.getInstance().reiniciarAlgoritmo();
                MapeoDeBloques.getInstance().agregarBloquePersonalizado((BloqueAgregable) nuevoPersonalizado.clonar());
                AgregadorBloques.getInstance().agregarBloquePersonalizado(nuevoPersonalizado);
                Algoblocks.getInstance().agregarBloqueAgregable(nuevoPersonalizado);
            });

            principal.getChildren().addAll(areaTexto, labelTexto, ingresar);
            pedirInput.setScene(escena);
            pedirInput.show();
        }
    }
}
