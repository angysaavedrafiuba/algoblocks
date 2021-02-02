package edu.fiuba.algo3;


import javafx.scene.control.Tab;

public class ColaDeInstrucciones {
    private final Recorrido strategy;

    ColaDeInstrucciones(Bloque primerBloque, Recorrido strategy){
        this.strategy = strategy;
        strategy.agregar(primerBloque);
    }

    ColaDeInstrucciones(Recorrido strategy){
        this.strategy = strategy;
    }

    public void ejecutar(Personaje personaje, Tablero tablero){
        strategy.primerBloque().ejecutar(personaje, tablero);
    }

    public void agregarBloque(Bloque bloque){
        strategy.primerBloque().enlazar(bloque, strategy);
    }

}
