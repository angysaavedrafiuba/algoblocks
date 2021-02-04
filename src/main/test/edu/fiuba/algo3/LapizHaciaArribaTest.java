package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LapizHaciaArribaTest {
    @Test
    public void test01ElLaLapizHaciaArribaNoDibujaUnaPosicion() {
        Dibujo dibujo = new Dibujo();
        LapizConPuntaHaciaArriba lapiz = new LapizConPuntaHaciaArriba();

        lapiz.dibujar(dibujo, new Posicion2D(0, 0));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());

    }

    @Test
    public void test02ElLapizHaciaArribaNoDibujaAunqueRecibaVariasPosiciones() {
        Dibujo dibujo = new Dibujo();
        LapizConPuntaHaciaArriba lapiz = new LapizConPuntaHaciaArriba();

        lapiz.dibujar(dibujo, new Posicion2D(0, 0));
        lapiz.dibujar(dibujo, new Posicion2D(1, 0));
        lapiz.dibujar(dibujo, new Posicion2D(0, 1));
        lapiz.dibujar(dibujo, new Posicion2D(0, 1));

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }
}
