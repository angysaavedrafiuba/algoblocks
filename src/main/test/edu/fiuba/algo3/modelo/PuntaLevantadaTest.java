package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PuntaLevantadaTest {
    PuntaLevantada punta = new PuntaLevantada();
    Dibujo dibujo = new Dibujo();

    @Test
    public void test01UnaPuntaLevantadaDibujaUnaPosicion2DCorrectamente() {
        punta.dibujar(dibujo, new Posicion2D(0, 0));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test02UnaPuntaLevantadaDibujaVariasPosiciones2DCorrectamente() {
        punta.dibujar(dibujo, new Posicion2D(0, 0));
        punta.dibujar(dibujo, new Posicion2D(1, 0));
        punta.dibujar(dibujo, new Posicion2D(0, 4));
        punta.dibujar(dibujo, new Posicion2D(-10, 4));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }
}