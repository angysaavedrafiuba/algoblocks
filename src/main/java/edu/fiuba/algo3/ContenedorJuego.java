package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class ContenedorJuego extends BorderPane {

    public ContenedorJuego(){
       this.SectorDibujo();
       this.SectorBloque();
       this.SectorAlgoritmo();
   }

    public void SectorBloque(){
        VBox vbox = new VBox();
        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(25));
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(new Text("Bloques"));
        vbox.getChildren().addAll(hbox,new Separator(Orientation.HORIZONTAL));
        this.setTop(vbox);

    }

    public void SectorAlgoritmo(){
        HBox hbox = new HBox();
        VBox vbox= new VBox(20);
        vbox.setPadding(new Insets(40));
        Text texto = new Text("Algoritmo");
        //texto.setFont(Font.font("Helvetica", FontPosture.ITALIC,15));
        vbox.getChildren().addAll(texto);
        hbox.getChildren().addAll(vbox, new Separator(Orientation.VERTICAL));

        this.setLeft(hbox);

    }

    public void SectorDibujo(){
        StackPane stack = new StackPane();
        stack.setAlignment(Pos.CENTER);
        Rectangle rectangulo = new Rectangle();
        rectangulo.setFill(Color.BEIGE);
        rectangulo.widthProperty().bind(stack.widthProperty().subtract(50));
        rectangulo.heightProperty().bind(stack.heightProperty().subtract(50));

        stack.getChildren().addAll(rectangulo);

        this.setCenter(stack);



    }

}
