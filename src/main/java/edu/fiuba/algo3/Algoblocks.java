package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

public class Algoblocks {
    private final Tablero tablero = new Tablero();
    private final List<Bloque> bloques = new ArrayList<>();


    /*public void agregarBloqueMoverALaDerecha() {
        Bloque bloque = new moverALaDerecha();
        bloques.add(bloque);
    }*/

    public void agregarBloqueSubirLapiz(){
        Bloque bloque = new subirLapiz();
        bloques.add(bloque);
    }
    public void agregarBloqueBajarLapiz(){
        Bloque bloque = new bajarLapiz();
        bloques.add(bloque);
    }

    public void ejecutar(){
        tablero.ejecutarAlgoritmo(bloques);
    }

    public boolean lapizEstaArriba() {
        return tablero.lapizArriba();
    }
}
