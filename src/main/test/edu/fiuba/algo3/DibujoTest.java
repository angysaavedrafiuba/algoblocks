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

        dibujo.dibujarConLapiz(new Posicion2D(0, 1), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(0, 1));

        dibujo.dibujarConLapiz(new Posicion2D(0, 2), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(1, 2), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(1, 2));

        dibujo.dibujarConLapiz(new Posicion2D(2, 2), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(2, 3), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(2, 3));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), dibujoEsperado.toArray());
    }

    @Test
    public void test04UnBloqueDeRepeticionDobleConMovimientoReflejaUnDibujoAcorde(){
        Dibujo dibujo = new Dibujo();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        RecorridoNormal algoritmo = new RecorridoNormal();
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(2);

        algoritmo.agregarBloque(new BajarLapiz());//(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueRepeticion); //(1, 0) & (2, 0)
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

        algoritmo.agregarBloque(new BajarLapiz());//(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueRepeticion); //(-1, 0), (-2, 0) & (-3, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(-2,0));
        dibujoEsperado.add(new Posicion2D(-3,0));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);

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

        algoritmo.agregarBloque(new BajarLapiz());//(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueDoble); //(1, 0), (0, 0), (1, 0) & (0, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(0,0));
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(0,0));
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(2,0));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        algoritmo.agregarBloque(bloqueTriple); //(0, 1), (0, 2) & (0, 3)
        dibujoEsperado.add(new Posicion2D(2, 1));
        dibujoEsperado.add(new Posicion2D(2, 2));
        dibujoEsperado.add(new Posicion2D(2, 3));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);

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

        algoritmo.agregarBloque(new BajarLapiz());//(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueDoble); //(-1, 0) & (-2, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(-2,0));

        bloqueInvertir.agregarBloque(new MoverALaIzquierda());
        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(bloqueTriple);
        algoritmo.agregarBloque(bloqueInvertir); //(-1, 0), (-1, -1), (-1, -2) & (-1, -3)

        dibujoEsperado.add(new Posicion2D(-1, 0));
        dibujoEsperado.add(new Posicion2D(-1, -1));
        dibujoEsperado.add(new Posicion2D(-1, -2));
        dibujoEsperado.add(new Posicion2D(-1, -3));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);

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

        algoritmo.agregarBloque(new BajarLapiz()); //(2, 0)
        dibujoEsperado.add(new Posicion2D(2,0));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueTriple.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueTriple); //(2, 1), (1, 1), (1, 2), (0, 2), (2, 3) & (-1, 3)
        dibujoEsperado.add(new Posicion2D(2, 1));
        dibujoEsperado.add(new Posicion2D(1, 1));
        dibujoEsperado.add(new Posicion2D(1, 2));
        dibujoEsperado.add(new Posicion2D(0, 2));
        dibujoEsperado.add(new Posicion2D(0, 3));
        dibujoEsperado.add(new Posicion2D(-1,3));

        algoritmo.agregarBloque(new SubirLapiz());
        algoritmo.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.agregarBloque(bloqueDoble);
        algoritmo.agregarBloque(bloqueInvertir); //(-2, 3), (-2, 2) & (-2, 1)
        dibujoEsperado.add(new Posicion2D(-2, 3));
        dibujoEsperado.add(new Posicion2D(-2, 2));
        dibujoEsperado.add(new Posicion2D(-2, 1));

        algoritmo.agregarBloque(new MoverHaciaAbajo()); //(-2, 0)
        dibujoEsperado.add(new Posicion2D(-2, 0));

        algoritmo.ejecutar(new Personaje(new Posicion2D(0, 0)), dibujo);
        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}
