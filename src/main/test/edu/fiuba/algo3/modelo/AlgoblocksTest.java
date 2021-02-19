package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoblocksTest {
    Algoblocks algoblocks = new Algoblocks(); //(10,10)
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(4);
    ArrayList<Posicion2D> dibujoLogrado;

    @Test
    public void test01IntegracionConBloquesDeMovimientoYLapiz() {
        algoblocks.agregarBloque(new MoverALaDerecha());    // (11,10)
        algoblocks.agregarBloque(new MoverALaDerecha());    // (12,10)
        algoblocks.agregarBloque(new MoverHaciaAbajo());    // (12,9)
        algoblocks.agregarBloque(new MoverALaIzquierda());  // (11,9)
        algoblocks.agregarBloque(new BajarLapiz());
        dibujoEsperado.add(new Posicion2D(11,9));

        //Ahora comienza a dibujar
        algoblocks.agregarBloque(new MoverALaDerecha());    // (12,9)
        dibujoEsperado.add(new Posicion2D(12, 9));

        algoblocks.agregarBloque(new MoverALaDerecha());    // (13,9)
        dibujoEsperado.add(new Posicion2D(13, 9));

        algoblocks.agregarBloque(new MoverHaciaArriba());   // (13,10)
        dibujoEsperado.add(new Posicion2D(13, 10));

        algoblocks.agregarBloque(new MoverALaDerecha());    // (14,10)
        dibujoEsperado.add(new Posicion2D(14, 10));

        algoblocks.agregarBloque(new SubirLapiz());

        //Ahora no dibuja
        algoblocks.agregarBloque(new MoverALaIzquierda());  // (13,10)
        algoblocks.agregarBloque(new MoverALaIzquierda());  // (12,10)

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test02IntegracionConBloquesDeMovimientoLapizRepeticionEInversion() {
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());

        algoblocks.agregarBloque(new BajarLapiz()); //(12, 10)
        dibujoEsperado.add(new Posicion2D(12,10));

        bloqueTriple.agregarBloque(new Bloque(new MoverHaciaArriba()));
        bloqueTriple.agregarBloque(new Bloque(new MoverALaIzquierda()));
        algoblocks.agregarBloque(bloqueTriple); //(12, 11), (11, 11), (11, 12), (10, 12), (10, 13) & (9, 13)
        dibujoEsperado.add(new Posicion2D(12, 11));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(10, 12));
        dibujoEsperado.add(new Posicion2D(10, 13));
        dibujoEsperado.add(new Posicion2D(9,13));

        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new Bloque(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(new Bloque(new SubirLapiz()));
        bloqueInvertir.agregarBloque(new Bloque(bloqueDoble));
        bloqueInvertir.agregarBloque(new Bloque(new BajarLapiz()));
        algoblocks.agregarBloque(bloqueInvertir); //(8, 13), (8, 12) & (8, 11)
        dibujoEsperado.add(new Posicion2D(8, 13));
        dibujoEsperado.add(new Posicion2D(8, 12));
        dibujoEsperado.add(new Posicion2D(8, 11));

        algoblocks.agregarBloque(new MoverHaciaAbajo());

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test03LuegoDeDibujarPosicionesElDibujoSeMantieneAunEjecutandoNuevamenteElAlgoritmo() {
        algoblocks.agregarBloque(new BajarLapiz()); //(10, 10)
        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

        algoblocks.reiniciarAlgoritmo();
        algoblocks.ejecutar();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test04ELDibujoSigueSiendoConsistenteSiSeReiniciaElAlgoritmoLuegoDeDibujarYSeAgreganNuevosBloques() {
        algoblocks.agregarBloque(new BajarLapiz()); //(10, 10)
        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();

        algoblocks.agregarBloque(new MoverHaciaAbajo());
        algoblocks.agregarBloque(new MoverHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(12,9));
        dibujoEsperado.add(new Posicion2D(12,8));

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05ELDibujoEsConsistenteAlDibujarEliminarBloquesYEjecutarNuevamente() {
        algoblocks.agregarBloque(new BajarLapiz()); //(10, 10)
        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();
        algoblocks.agregarBloque(new MoverHaciaAbajo());
        algoblocks.agregarBloque(new MoverALaIzquierda());
        algoblocks.agregarBloque(new MoverHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(12,9));
        dibujoEsperado.add(new Posicion2D(11,9));
        dibujoEsperado.add(new Posicion2D(11,8));

        algoblocks.ejecutar();
        algoblocks.removerUltimo();

        dibujoEsperado.add(new Posicion2D(11,7));
        dibujoEsperado.add(new Posicion2D(10,7));

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test06ElDibujoPuedeReiniciarseYLuegoDibujarNuevamente() {
        algoblocks.agregarBloque(new BajarLapiz()); //(10, 10)
        algoblocks.agregarBloque(new MoverALaDerecha());
        algoblocks.agregarBloque(new MoverALaDerecha());
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

        algoblocks.reiniciarDibujo();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertTrue(dibujoLogrado.isEmpty());

        dibujoEsperado = new ArrayList<Posicion2D>();
        dibujoEsperado.add(new Posicion2D(12,10));
        dibujoEsperado.add(new Posicion2D(13,10));
        dibujoEsperado.add(new Posicion2D(14,10));
        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}

