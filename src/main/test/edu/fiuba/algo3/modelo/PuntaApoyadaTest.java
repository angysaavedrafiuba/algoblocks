package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PuntaApoyadaTest {
    PuntaApoyada punta = new PuntaApoyada();
    Dibujo dibujo = new Dibujo();
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();

    @Test
    public void test01UnaPuntaLevantadaDibujaUnaPosicion2DCorrectamente() {
        punta.dibujar(dibujo, new Posicion2D(0, 0));

        dibujoEsperado.add(new Posicion2D(0, 0));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02UnaPuntaLevantadaDibujaVariasPosiciones2DCorrectamente() {
        punta.dibujar(dibujo, new Posicion2D(0, 0));
        punta.dibujar(dibujo, new Posicion2D(1, 0));
        punta.dibujar(dibujo, new Posicion2D(0, 4));
        punta.dibujar(dibujo, new Posicion2D(-10, 4));

        dibujoEsperado.add(new Posicion2D(0, 0));
        dibujoEsperado.add(new Posicion2D(1, 0));
        dibujoEsperado.add(new Posicion2D(0, 4));
        dibujoEsperado.add(new Posicion2D(-10, 4));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }
}
