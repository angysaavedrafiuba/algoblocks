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
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));    // (11,10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));    // (12,10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));    // (12,9)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));  // (11,9)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        dibujoEsperado.add(new Posicion2D(11,9));

        //Ahora comienza a dibujar
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));    // (12,9)
        dibujoEsperado.add(new Posicion2D(12, 9));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));    // (13,9)
        dibujoEsperado.add(new Posicion2D(13, 9));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaArriba()));   // (13,10)
        dibujoEsperado.add(new Posicion2D(13, 10));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));    // (14,10)
        dibujoEsperado.add(new Posicion2D(14, 10));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new SubirLapiz()));

        //Ahora no dibuja
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));  // (13,10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));  // (12,10)

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test02IntegracionConBloquesDeMovimientoLapizRepeticionEInversion() {
        BloqueAgregable bloqueDoble = new BloqueAgregable(new BloqueDeRepeticion(2));
        BloqueAgregable bloqueTriple = new BloqueAgregable(new BloqueDeRepeticion(3));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz())); //(12, 10)
        dibujoEsperado.add(new Posicion2D(12,10));

        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoblocks.agregarBloqueAgregable(bloqueTriple); //(12, 11), (11, 11), (11, 12), (10, 12), (10, 13) & (9, 13)
        dibujoEsperado.add(new Posicion2D(12, 11));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(10, 12));
        dibujoEsperado.add(new Posicion2D(10, 13));
        dibujoEsperado.add(new Posicion2D(9,13));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new SubirLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        bloqueInvertir.agregarBloque(bloqueDoble);
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueAgregable(bloqueInvertir); //(8, 13), (8, 12) & (8, 11)
        dibujoEsperado.add(new Posicion2D(8, 13));
        dibujoEsperado.add(new Posicion2D(8, 12));
        dibujoEsperado.add(new Posicion2D(8, 11));

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test03LuegoDeDibujarPosicionesElDibujoSeMantieneAunEjecutandoNuevamenteElAlgoritmo() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz())); //(10, 10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
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
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz())); //(10, 10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        dibujoEsperado.add(new Posicion2D(12,9));
        dibujoEsperado.add(new Posicion2D(12,8));

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05ELDibujoEsConsistenteAlDibujarEliminarBloquesYEjecutarNuevamente() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz())); //(10, 10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
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
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz())); //(10, 10)
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
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

