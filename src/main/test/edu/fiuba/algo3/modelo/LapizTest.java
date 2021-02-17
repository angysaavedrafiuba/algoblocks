package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Dibujo;
import edu.fiuba.algo3.modelo.Lapiz;
import edu.fiuba.algo3.modelo.Posicion2D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LapizTest {
    @Test
    public void test01ElLaLapizHaciaArribaNoDibujaUnaPosicion() {
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz();

        lapiz.dibujar(dibujo, new Posicion2D(0, 0));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());

    }

    @Test
    public void test02ElLapizHaciaArribaNoDibujaAunqueRecibaVariasPosiciones() {
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz();

        lapiz.dibujar(dibujo, new Posicion2D(0, 0));
        lapiz.dibujar(dibujo, new Posicion2D(1, 0));
        lapiz.dibujar(dibujo, new Posicion2D(0, 1));
        lapiz.dibujar(dibujo, new Posicion2D(0, 1));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test03DibujandoUnaSolaVezElDibujoTieneUnaSolaPosicion(){
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz();
        lapiz.apoyar();

        lapiz.dibujar(dibujo, new Posicion2D(0,0));

        assertTrue(dibujo.posicionesDibujadas().get(0).esLaMismaQue(new Posicion2D(0, 0)));
    }

    @Test
    public void test04TodasLasPosicionesPasadasADibujarEstanEnElDibujo(){
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz();
        lapiz.apoyar();
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
