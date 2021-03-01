package edu.fiuba.algo3.controlador;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorDeJuego implements Initializable {

    Scene scene;
    @FXML
    public ImageView source;
    @FXML
    public ImageView target;

    public ControladorDeJuego(){};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void init(Scene scene){ this.scene = scene; }

    @FXML
    public void setPointer(Event e){
        this.scene.setCursor(Cursor.HAND);
    }

    @FXML
    public void setDefaultCursor(MouseEvent mouseEvent) {
        this.scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void logClick(MouseEvent e){
        System.out.println("Me han clickeado!!!");
    }

    @FXML
    public void handleDragDetection(MouseEvent event) {
        Dragboard db = this.source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(this.source.getImage());
        db.setContent(cb);
        event.consume();
    }

    @FXML
    public void handleImageDragOver(DragEvent event){
        if (event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    public void handleImageDrop(DragEvent event){
        Image image = event.getDragboard().getImage();
        target.setImage(image);
        //https://www.genuinecoder.com/drag-and-drop-in-javafx-html/
    }

}
