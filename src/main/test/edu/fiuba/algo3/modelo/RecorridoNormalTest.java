package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecorridoNormalTest {
    RecorridoNormal recorrido = new RecorridoNormal();
    Dibujo dibujo = new Dibujo();
    Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();

    @Test
    public void test01SeAgregaUnBloqueAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverALaDerecha());
        dibujoEsperado.add(new Posicion2D(11, 10));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganDosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.agregarBloque(new MoverHaciaArriba());
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(11, 11));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganVariosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        BloqueDeRepeticion repeticion = new BloqueDeRepeticion(3);

        recorrido.agregarBloque(new MoverALaDerecha());
        repeticion.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(repeticion);
        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(11, 13));
        dibujoEsperado.add(new Posicion2D(11, 14));
        dibujoEsperado.add(new Posicion2D(11, 13));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test04InvertirUnRecorridoDeUnBloqueGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(9, 10));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test05InvertirUnRecorridoConVariosBloquesGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.agregarBloque(new MoverALaIzquierda());
        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test06InvertirUnRecorridoConBloquesCombinadosGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        BloqueDeRepeticion repeticion = new BloqueDeRepeticion(2);
        InvertirComportamiento inversion = new InvertirComportamiento();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        inversion.agregarBloque(new MoverALaDerecha());
        repeticion.agregarBloque(inversion);
        recorrido.agregarBloque(repeticion);
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(12, 10));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test07EjecutarDosVecesElMismoRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        recorrido.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(9, 9));
        dibujoEsperado.add(new Posicion2D(9, 8));
        dibujoEsperado.add(new Posicion2D(8, 8));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test08EjecutarUnRecorridoLuegoInvertirloYVolverloAEjecutarDibujaAcordemente() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        recorrido.ejecutar(personaje, dibujo);
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(9, 8));
        dibujoEsperado.add(new Posicion2D(9, 9));
        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(10, 10));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test09EjecutarUnRecorridoLuegoDeReiniciarloNoGeneraDibujo() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        recorrido.ejecutar(personaje, dibujo);
        recorrido.reiniciar();

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test10EjecutarUnRecorridoLuegoDeReiniciarYAgregarleBloquesGeneraDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        recorrido.ejecutar(personaje, dibujo);
        recorrido.reiniciar();
        recorrido.ejecutar(personaje, dibujo);

        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.agregarBloque(new MoverHaciaAbajo());

        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(10, 8));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test11CombinarAgregadoDeBloquesConReinicioEInversionDeUnRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(11, 11));

        recorrido.ejecutar(personaje, dibujo);
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(10, 10));

        recorrido.ejecutar(personaje, dibujo);
        recorrido.reiniciar();

        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.invertir();

        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(9, 11));

        recorrido.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test12InvertirYEjecutarUnRecorridoVacioNoGeneraNingunEfectoNiDibujo() {
        recorrido.invertir();
        recorrido.ejecutar(personaje, dibujo);

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test13RemoverUnBloqueDeUnRecorridoVacioNoAfectaSuIntegridad() {
        personaje.apoyarLapiz();

        recorrido.removerUltimo();
        recorrido.ejecutar(personaje, dibujo);

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test14RemuevoElUltimoBloqueYElAlgoritmoEjecutadoEsCorrecto() {
        personaje.apoyarLapiz();

        recorrido.agregarBloque(new MoverHaciaArriba());
        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new MoverALaIzquierda());
        recorrido.agregarBloque(new MoverALaDerecha());
        recorrido.removerUltimo();
        recorrido.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(9, 10));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }
}
