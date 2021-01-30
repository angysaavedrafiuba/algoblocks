package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoBlocksTest {
    /*
    @Test
    public void testDeIntegracion(){
        Algoblocks algoblocks = new Algoblocks();           // (0,0)
        ArrayList<Posicion> dibujoEsperado = new ArrayList<Posicion>(4);
        ArrayList<Posicion> dibujoLogrado = new ArrayList<Posicion>(4);

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

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertEquals(dibujoEsperado, dibujoLogrado);
    }

    @Test
    public void test01PersonajeSeCrearConLapizArriba() {

        Algoblocks algoblocks = new Algoblocks();
        assertTrue(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test02seCreaUnPersonajeYseEnviaElBloqueLapizAbajoYElLapizAhoraNoEstaArriba() {
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.ejecutar();

        assertFalse(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test03SeBajaYseVuelveASubirElLapizYEsteQuedaHaciaArriba(){

        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());

    }

    @Test
    public void test04SeAplicaBloqueHaciaArribaYEsteNoModificaElEstadoDelLapiz(){
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());
    }
    */
}

