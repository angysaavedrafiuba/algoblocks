package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoBlocksTest {

    private Boolean compararArrays(ArrayList<Posicion2D>array1, ArrayList<Posicion2D>array2){
        int i = 0;
        if(array1.size() != array2.size()) return false;

        for (Posicion posicion: array1) {
            Posicion2D posicion2 = array2.get(i);
            if(!posicion.esLaMismaQue(posicion2)) return false;
            i++;
        }

        return true;
    }

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

        assertTrue(compararArrays(dibujoEsperado, dibujoLogrado));

    }
}

