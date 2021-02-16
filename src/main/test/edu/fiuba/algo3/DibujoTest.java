package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void test01ElDibujoSeCreaEnBlanco(){
        Dibujo dibujo = new Dibujo();

        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test02SiDibujamosLaPosicion2y2LuegoSeEncuentraDibujada(){
        Dibujo dibujo = new Dibujo();
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujar(posicionADibujar);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test03DibujarConUnLapizHaciaArribaNoProduceDibujo(){
        Dibujo dibujo = new Dibujo();
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujarConLapiz(posicionADibujar, new Lapiz());
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test04SiDibujamosLaPosicion2y2ConUnLapizHaciaAbajoEfectivamenteSeDibuja(){
        Dibujo dibujo = new Dibujo();
        Posicion2D posicionADibujar = new Posicion2D(2,2);
        Lapiz lapiz = new Lapiz();
        lapiz.apoyar();

        dibujo.dibujarConLapiz(posicionADibujar, lapiz);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test05IntercalarLapizLevantadoYApoyadoNoAfectaElComportamientoDelDibujo() {
        Dibujo dibujo = new Dibujo();
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(5);
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
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(2);

        algoritmo.agregarBloque(new BajarLapiz()); //(10,10)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueRepeticion); //(11, 10) & (12, 10)
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(2,0));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05UnBloqueDeRepeticionTripleConMovimientoReflejaUnDibujoAcorde(){
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(3);

        algoritmo.agregarBloque(new BajarLapiz()); //(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueRepeticion.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueRepeticion); //(9, 10), (8, 10) & (7, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(8,10));
        dibujoEsperado.add(new Posicion2D(7,10));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test06VariosBloquesDeRepeticionConMovimientosCombinadosReflejanUnDibujoAcorde(){
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);

        algoritmo.agregarBloque(new BajarLapiz());//(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueDoble); //(9, 10), (10, 10), (11, 10) & (10, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(10,10));
        dibujoEsperado.add(new Posicion2D(11,10));
        dibujoEsperado.add(new Posicion2D(12,10));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        algoritmo.agregarBloque(bloqueTriple); //(10, 11), (10, 12) & (10, 13)
        dibujoEsperado.add(new Posicion2D(12, 11));
        dibujoEsperado.add(new Posicion2D(12, 12));
        dibujoEsperado.add(new Posicion2D(12, 13));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test07UnBloqueDeRepeticionDentroDeUnInvertirComportamientoGeneraUnDibujoAcorde(){
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoritmo.agregarBloque(new BajarLapiz());//(10,10)
        dibujoEsperado.add(new Posicion2D(10,10));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueDoble); //(9, 10) & (8, 10)
        dibujoEsperado.add(new Posicion2D(9,10));
        dibujoEsperado.add(new Posicion2D(8,10));

        bloqueInvertir.agregarBloque(new MoverALaIzquierda());
        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(bloqueTriple);
        algoritmo.agregarBloque(bloqueInvertir); //(9, 10), (9, 9), (9, 8) & (9, 7)

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
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoritmo.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(new MoverALaDerecha());

        algoritmo.agregarBloque(new BajarLapiz()); //(12, 10)
        dibujoEsperado.add(new Posicion2D(12,10));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueTriple.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueTriple); //(12, 11), (11, 11), (11, 12), (10, 12), (12, 13) & (9, 13)
        dibujoEsperado.add(new Posicion2D(12, 11));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(10, 12));
        dibujoEsperado.add(new Posicion2D(10, 13));
        dibujoEsperado.add(new Posicion2D(9,13));

        algoritmo.agregarBloque(new SubirLapiz());
        algoritmo.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.agregarBloque(bloqueDoble);
        algoritmo.agregarBloque(bloqueInvertir); //(8, 13), (8, 12) & (8, 11)
        dibujoEsperado.add(new Posicion2D(8, 13));
        dibujoEsperado.add(new Posicion2D(8, 12));
        dibujoEsperado.add(new Posicion2D(8, 11));

        algoritmo.agregarBloque(new MoverHaciaAbajo()); //(8, 10)
        dibujoEsperado.add(new Posicion2D(8, 10));

        algoritmo.ejecutar(new Personaje(new Posicion2D(10, 10)), dibujo);
        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}
