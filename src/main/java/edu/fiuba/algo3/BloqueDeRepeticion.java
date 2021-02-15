package edu.fiuba.algo3;

import java.util.ArrayList;

public class BloqueDeRepeticion implements Bloque{
    private ColaDeInstrucciones secuencia = new ColaDeInstrucciones(new RecorridoNormal());
    private int repeticiones;
    private Bloque siguienteBloque = new BloqueNulo();

    BloqueDeRepeticion(int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        for(int i=0; i<repeticiones; i++) {
            secuencia.ejecutar(personaje, dibujo);
        }
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    @Override
    public void siguiente(Bloque bloque) {
        siguienteBloque = bloque;
    }

    @Override
    public void enlazar(Bloque bloque, Recorrido strategy){
        try {
            strategy.agregar(bloque);
        }
        catch (RuntimeException e){
            throw e;
        }
    }

    public void agregarBloque(Bloque bloque) {
        secuencia.agregarBloque(bloque);
    }
}
