package edu.fiuba.algo3;


import java.util.ArrayList;

public class Algoblocks {
    private final Tablero tablero = new Tablero();
    private final ArrayList<Bloque> bloques = new ArrayList<>();

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public void ejecutar(){
        tablero.ejecutarAlgoritmo(bloques);
    }

    public boolean lapizEstaArriba() {
        return tablero.lapizArriba();
    }
}
