package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {
    Dibujo dibujo = new Dibujo();
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();
    RecorridoNormal algoritmo = new RecorridoNormal();

    @Test
    public void test01ElDibujoSeCreaEnBlanco(){
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test02SiDibujamosLaPosicion2y2LuegoSeEncuentraDibujada(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujar(posicionADibujar);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test03DibujarConUnLapizHaciaArribaNoProduceDibujo(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujarConLapiz(posicionADibujar, new Lapiz());
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test04SiDibujamosLaPosicion2y2ConUnLapizHaciaAbajoEfectivamenteSeDibuja(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);
        Lapiz lapiz = new Lapiz();
        lapiz.apoyar();

        dibujo.dibujarConLapiz(posicionADibujar, lapiz);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test05IntercalarLapizLevantadoYApoyadoNoAfectaElComportamientoDelDibujo() {
        Lapiz lapizApoyado = new Lapiz();
        lapizApoyado.apoyar();
        Lapiz lapizLevantado = new Lapiz();

        dibujo.dibujarConLapiz(new Posicion2D(10, 11), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(10, 11));

        dibujo.dibujarConLapiz(new Posicion2D(10, 12), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(11, 12), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(11, 12));

        dibujo.dibujarConLapiz(new Posicion2D(12, 12), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(12, 13), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(12, 13));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), dibujoEsperado.toArray());
    }

    @Test
    public void test04UnBloqueDeRepeticionDobleConMovimientoReflejaUnDibujoAcorde(){
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(2);

        algoritmo.agregarBloque(new Bloque(new BajarLapiz())); //(10,10)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new Bloque(new MoverALaDerecha()));
        algoritmo.agregarBloque(new Bloque(bloqueRepeticion)); //(11, 10) & (12, 10)
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(2,0));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05UnBloqueDeRepeticionTripleConMovimientoReflejaUnDibujoAcorde(){
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(3);

        algoritmo.agregarBloque(new Bloque(new BajarLapiz())); //(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueRepeticion.agregarBloque(new Bloque(new MoverALaIzquierda()));
        algoritmo.agregarBloque(new Bloque(bloqueRepeticion)); //(9, 10), (8, 10) & (7, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(8,10));
        dibujoEsperado.add(new Posicion2D(7,10));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test06VariosBloquesDeRepeticionConMovimientosCombinadosReflejanUnDibujoAcorde(){
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);

        algoritmo.agregarBloque(new Bloque(new BajarLapiz()));//(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueDoble.agregarBloque(new Bloque(new MoverALaIzquierda()));
        bloqueDoble.agregarBloque(new Bloque(new MoverALaDerecha()));
        bloqueDoble.agregarBloque(new Bloque(new MoverALaDerecha()));
        algoritmo.agregarBloque(new Bloque(bloqueDoble)); //(9, 10), (10, 10), (11, 10) & (10, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        bloqueTriple.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(bloqueTriple)); //(10, 11), (10, 12) & (10, 13)
        dibujoEsperado.add(new Posicion2D(12, 11));
        dibujoEsperado.add(new Posicion2D(12, 12));
        dibujoEsperado.add(new Posicion2D(12, 13));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test07UnBloqueDeRepeticionDentroDeUnInvertirComportamientoGeneraUnDibujoAcorde(){
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoritmo.agregarBloque(new Bloque(new BajarLapiz()));//(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueDoble.agregarBloque(new Bloque(new MoverALaIzquierda()));
        algoritmo.agregarBloque(new Bloque(bloqueDoble)); //(9, 10) & (8, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(8,10));

        bloqueInvertir.agregarBloque(new Bloque(new MoverALaIzquierda()));
        bloqueTriple.agregarBloque(new Bloque(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(new Bloque(bloqueTriple));
        algoritmo.agregarBloque(new Bloque(bloqueInvertir)); //(9, 10), (9, 9), (9, 8) & (9, 7)

        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(9, 9));
        dibujoEsperado.add(new Posicion2D(9, 8));
        dibujoEsperado.add(new Posicion2D(9, 7));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test08BloquesDeSubirYBajarJuntoConRepeticionEInversionGeneranDibujoAcorde(){
        int repeticionesPrimerBloque = 2;
        int repeticionesSegundoBloque = 3;

        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(repeticionesPrimerBloque);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(repeticionesSegundoBloque);

        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        Posicion2D posicionActual = Posicion2D.posicionInicial();


        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());

        algoritmo.agregarBloque(new Bloque(new BajarLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueTriple.agregarBloque(new Bloque(new MoverHaciaArriba()));
        bloqueTriple.agregarBloque(new Bloque(new MoverALaIzquierda()));

        for (int i = 0; i < repeticionesSegundoBloque; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.agregarBloque(new Bloque(bloqueTriple));

        algoritmo.agregarBloque(new Bloque(new SubirLapiz()));

        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());

        bloqueInvertir.agregarBloque(new Bloque(new SubirLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueDoble.agregarBloque(new Bloque(new MoverHaciaArriba()));
        for (int i = 0; i < repeticionesSegundoBloque; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);
        }

        bloqueInvertir.agregarBloque(new Bloque(bloqueDoble));

        algoritmo.agregarBloque(new Bloque(bloqueInvertir));

        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());

        algoritmo.ejecutar(new Personaje(Posicion2D.posicionInicial()), dibujo);
        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test09ElDibujoSeEncuentraEnBlancoLuegoDeReiniciarlo() {
        algoritmo.agregarBloque(new Bloque(new BajarLapiz()));
        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(11, 10));
        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());

        dibujo.reiniciar();

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test10PuedoVolverADibujarLuegoDeReiniciarElDibujo() {
        algoritmo.agregarBloque(new Bloque(new BajarLapiz()));
        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(11, 10));
        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        dibujo.reiniciar();

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }
}

// bajar  /     rep1      /      rep2     /     rep3      /
// 12,10 / 12,11 / 13,11 / 13,12 / 14,12 / 14,13 / 15,13 /