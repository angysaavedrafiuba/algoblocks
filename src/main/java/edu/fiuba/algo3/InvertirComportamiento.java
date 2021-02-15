package edu.fiuba.algo3;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class InvertirComportamiento implements Bloque {
    private final ColaDeInstrucciones secuencia = new ColaDeInstrucciones(new RecorridoInverso());
    private Bloque siguienteBloque = new BloqueNulo();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        secuencia.ejecutar(personaje, dibujo);
        siguienteBloque.ejecutar(personaje, dibujo);
    }

    @Override
    public void siguiente(Bloque bloque){
        siguienteBloque = bloque;
    }

    public void agregarBloque(Bloque bloque) {
        secuencia.agregarBloque(bloque);
    }
}
