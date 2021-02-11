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

        dibujo.dibujarConLapiz(posicionADibujar, new LapizConPuntaHaciaArriba());
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test04SiDibujamosLaPosicion2y2ConUnLapizHaciaAbajoEfectivamenteSeDibuja(){
        Dibujo dibujo = new Dibujo();
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujarConLapiz(posicionADibujar, new LapizConPuntaHaciaAbajo());
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test05IntercalarLapizLevantadoYApoyadoNoAfectaElComportamientoDelDibujo() {
        Dibujo dibujo = new Dibujo();
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(5);

        dibujo.dibujarConLapiz(new Posicion2D(0, 1), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(0, 1));

        dibujo.dibujarConLapiz(new Posicion2D(0, 2), new LapizConPuntaHaciaArriba());
        dibujo.dibujarConLapiz(new Posicion2D(1, 2), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(1, 2));

        dibujo.dibujarConLapiz(new Posicion2D(2, 2), new LapizConPuntaHaciaArriba());
        dibujo.dibujarConLapiz(new Posicion2D(2, 3), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(2, 3));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), dibujoEsperado.toArray());
    }

    @Test
    public void test06UnBloqueDeRepeticionDobleProduceUnDibujoAcorde() {
        Dibujo dibujo = new Dibujo();
        ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(2);

        dibujo.dibujarConLapiz(new Posicion2D(0, 1), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(0, 1));

        dibujo.dibujarConLapiz(new Posicion2D(0, 2), new LapizConPuntaHaciaArriba());
        dibujo.dibujarConLapiz(new Posicion2D(1, 2), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(1, 2));

        dibujo.dibujarConLapiz(new Posicion2D(2, 2), new LapizConPuntaHaciaArriba());
        dibujo.dibujarConLapiz(new Posicion2D(2, 3), new LapizConPuntaHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(2, 3));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), dibujoEsperado.toArray());
    }
}
