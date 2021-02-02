package edu.fiuba.algo3;


import java.util.ArrayList;

public class Algoblocks {
    private final Tablero tablero = new Tablero();
    private final ColaDeInstrucciones bloques = new ColaDeInstrucciones(new RecorridoNormal());

    public void agregarBloque(Bloque bloque){
        bloques.agregarBloque(bloque);
    }

    public void ejecutar(){
        tablero.ejecutarAlgoritmo(bloques);
    }


    //Test only
    public ArrayList<Posicion2D> obtenerDibujo() {
        return this.tablero.obtenerDibujo();
    }
}
