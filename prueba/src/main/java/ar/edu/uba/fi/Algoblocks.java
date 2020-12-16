package ar.edu.uba.fi;

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
        for(Bloque bloque: bloques){
            bloque.ejecutar(this.tablero);
        }
    }

    public boolean lapizEstaArriba() {
        return tablero.lapizArriba();
    }
}
