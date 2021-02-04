package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoBlocksTest {

    @Test
    public void testDeIntegracion(){
        Algoblocks algoblocks = new Algoblocks();           // (0,0)
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<Posicion2D>(4);
        ArrayList<Posicion2D> dibujoLogrado = new ArrayList<Posicion2D>(4);

        algoblocks.agregarBloque(new MoverALaDerecha());    // (1,0)
        algoblocks.agregarBloque(new MoverALaDerecha());    // (2,0)
        algoblocks.agregarBloque(new MoverHaciaAbajo());    // (2,-1)


        algoblocks.agregarBloque(new MoverALaIzquierda());  // (1,-1)
        algoblocks.agregarBloque(new BajarLapiz());
        dibujoEsperado.add(new Posicion2D(1,-1));

        //Ahora comienza a dibujar
        algoblocks.agregarBloque(new MoverALaDerecha());    // (2,-1)
        dibujoEsperado.add(new Posicion2D(2, -1));

        algoblocks.agregarBloque(new MoverALaDerecha());    // (3,-1)
        dibujoEsperado.add(new Posicion2D(3, -1));

        algoblocks.agregarBloque(new MoverHaciaArriba());   // (3,0)
        dibujoEsperado.add(new Posicion2D(3, 0));

        algoblocks.agregarBloque(new MoverALaDerecha());    // (4,0)
        dibujoEsperado.add(new Posicion2D(4, 0));

        algoblocks.agregarBloque(new SubirLapiz());

        //Ahora no dibuja
        algoblocks.agregarBloque(new MoverALaIzquierda());  // (3,0)
        algoblocks.agregarBloque(new MoverALaIzquierda());  // (2,0)

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

    }
}

