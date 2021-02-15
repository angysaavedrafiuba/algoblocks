package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LapizHaciaAbajoTest {

    @Test
    public void test01DibujandoUnaSolaVezElDibujoTieneUnaSolaPosicion(){
        Dibujo dibujo = new Dibujo();
        LapizConPuntaHaciaAbajo lapiz = new LapizConPuntaHaciaAbajo();

        lapiz.dibujar(dibujo, new Posicion2D(0,0));

        assertTrue(dibujo.posicionesDibujadas().get(0).igualA(new Posicion2D(0, 0)));
    }

    @Test
    public void test02TodasLasPosicionesPasadasADibujarEstanEnElDibujo(){
        Dibujo dibujo = new Dibujo();
        LapizConPuntaHaciaAbajo lapiz = new LapizConPuntaHaciaAbajo();
        ArrayList<Posicion2D> posicionesDibujadasEsperadas = new ArrayList<>();

        lapiz.dibujar(dibujo, new Posicion2D(0,0));
        posicionesDibujadasEsperadas.add(new Posicion2D(0,0));

        lapiz.dibujar(dibujo, new Posicion2D(1,0));
        posicionesDibujadasEsperadas.add(new Posicion2D(1,0));

        lapiz.dibujar(dibujo, new Posicion2D(3,0));
        posicionesDibujadasEsperadas.add(new Posicion2D(3,0));

        lapiz.dibujar(dibujo, new Posicion2D(0,5));
        posicionesDibujadasEsperadas.add(new Posicion2D(0, 5));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), posicionesDibujadasEsperadas.toArray());

    }
}
