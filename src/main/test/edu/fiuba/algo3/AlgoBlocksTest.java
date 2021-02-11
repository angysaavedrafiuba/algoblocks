package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {

    @Test
    public void test01IntegracionConBloquesDeMovimientoYLapiz() {
        Algoblocks algoblocks = new Algoblocks();           // (0,0)
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(4);
        ArrayList<Posicion2D> dibujoLogrado;

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

    @Test
    public void test02IntegracionConBloquesDeMovimientoLapizRepeticionEInversion() {
        Algoblocks algoblocks = new Algoblocks();           // (0,0)
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();
        ArrayList<Posicion2D> dibujoLogrado;
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());

        algoblocks.agregarBloque(new BajarLapiz()); //(2, 0)
        dibujoEsperado.add(new Posicion2D(2,0));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueTriple.agregarBloque(new MoverALaIzquierda());
        algoblocks.agregarBloque(bloqueTriple); //(2, 1), (1, 1), (1, 2), (0, 2), (2, 3) & (-1, 3)
        dibujoEsperado.add(new Posicion2D(2, 1));
        dibujoEsperado.add(new Posicion2D(1, 1));
        dibujoEsperado.add(new Posicion2D(1, 2));
        dibujoEsperado.add(new Posicion2D(0, 2));
        dibujoEsperado.add(new Posicion2D(0, 3));
        dibujoEsperado.add(new Posicion2D(-1,3));

        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(bloqueDoble);
        bloqueInvertir.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(bloqueInvertir); //(-2, 3), (-2, 4) & (-2, 5)

        dibujoEsperado.add(new Posicion2D(-2, 3));
        dibujoEsperado.add(new Posicion2D(-2, 4));
        dibujoEsperado.add(new Posicion2D(-2, 5));

        algoblocks.agregarBloque(new MoverHaciaAbajo()); //(-2, 4)
        dibujoEsperado.add(new Posicion2D(-2, 4));

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}

