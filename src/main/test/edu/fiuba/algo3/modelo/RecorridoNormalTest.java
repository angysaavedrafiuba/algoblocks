package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecorridoNormalTest {
    RecorridoNormal algoritmo = new RecorridoNormal();
    Dibujo dibujo = new Dibujo();
    Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();

    @Test
    public void test01SeAgregaUnBloqueAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        dibujoEsperado.add(new Posicion2D(11, 10));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganDosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(11, 11));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganVariosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        Bloque repeticion = new Bloque(new BloqueDeRepeticion(3));

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        repeticion.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(repeticion);
        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        dibujoEsperado.add(new Posicion2D(11, 10));
        dibujoEsperado.add(new Posicion2D(11, 11));
        dibujoEsperado.add(new Posicion2D(11, 12));
        dibujoEsperado.add(new Posicion2D(11, 13));
        dibujoEsperado.add(new Posicion2D(11, 14));
        dibujoEsperado.add(new Posicion2D(11, 13));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test04InvertirUnRecorridoDeUnBloqueGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        InvertirComportamiento invertido = new InvertirComportamiento();
        Posicion2D posicionActual = Posicion2D.posicionInicial();

        invertido.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(invertido));
        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test05InvertirUnRecorridoConVariosBloquesGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        InvertirComportamiento invertido = new InvertirComportamiento();
        Posicion2D posicionActual = Posicion2D.posicionInicial();

        invertido.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(invertido));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test06InvertirUnRecorridoConBloquesCombinadosGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        int repeticiones = 2;
        BloqueDeRepeticion repeticion = new BloqueDeRepeticion(repeticiones);
        InvertirComportamiento invertido = new InvertirComportamiento();
        Posicion2D posicionActual = Posicion2D.posicionInicial();

        invertido.agregarBloque(new Bloque(new MoverHaciaArriba()));
        invertido.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        invertido.agregarBloque(new Bloque(new MoverALaDerecha()));


        for (int i = 0; i < repeticiones; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        repeticion.agregarBloque(new Bloque(invertido));
        algoritmo.agregarBloque(new Bloque(repeticion));


        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test07EjecutarDosVecesElMismoRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();


        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        algoritmo.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(9, 10));
        dibujoEsperado.add(new Posicion2D(9, 9));
        dibujoEsperado.add(new Posicion2D(9, 8));
        dibujoEsperado.add(new Posicion2D(8, 8));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test08EjecutarUnRecorridoLuegoInvertirloYVolverloAEjecutarDibujaAcordemente() {
        personaje.apoyarLapiz();
        Posicion2D posicionActual = Posicion2D.posicionInicial();
        InvertirComportamiento invertido = new InvertirComportamiento();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);


        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        invertido.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(invertido));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test09EjecutarUnRecorridoLuegoDeReiniciarloNoGeneraDibujo() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test10EjecutarUnRecorridoLuegoDeReiniciarYAgregarleBloquesGeneraDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(9, 9));

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();
        algoritmo.ejecutar(personaje, dibujo);

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));

        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(10, 8));

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test11CombinarAgregadoDeBloquesConReinicioEInversionDeUnRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        InvertirComportamiento invertido = new InvertirComportamiento();
        Posicion2D posicionActual = Posicion2D.posicionInicial();

        invertido.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(invertido));

        algoritmo.ejecutar(personaje, dibujo);

        algoritmo.reiniciar();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test12InvertirYEjecutarUnRecorridoVacioNoGeneraNingunEfectoNiDibujo() {
        algoritmo.ejecutar(personaje, dibujo);

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test13RemoverUnBloqueDeUnRecorridoVacioNoAfectaSuIntegridad() {
        personaje.apoyarLapiz();

        algoritmo.removerUltimo();
        algoritmo.ejecutar(personaje, dibujo);

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test14RemuevoElUltimoBloqueYElAlgoritmoEjecutadoEsCorrecto() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverALaIzquierda()));
        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        algoritmo.removerUltimo();
        algoritmo.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));
        dibujoEsperado.add(new Posicion2D(9, 10));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test15PuedeRemoverseUnBloqueYLuegoAgregarUnNuevoYElComportamientoEsCorrecto() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.removerUltimo();
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(10, 11));
        dibujoEsperado.add(new Posicion2D(10, 10));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test16IntentarRemoverDeUnRecorridoVacioYLuegoAgregarNuevosBloquesNoCausaProblemas() {
        personaje.apoyarLapiz();

        algoritmo.removerUltimo();
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new Bloque(new MoverHaciaAbajo()));
        algoritmo.ejecutar(personaje, dibujo);

        dibujoEsperado.add(new Posicion2D(10, 9));
        dibujoEsperado.add(new Posicion2D(10, 8));
        dibujoEsperado.add(new Posicion2D(10, 7));

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test17PuedeRemoverseElUltimoBloqueDeUnBloqueDeRepeticionYElFuncionamientoEsCorrecto() {
        int repeticiones = 2;
        BloqueDeRepeticion repeticion = new BloqueDeRepeticion(repeticiones);
        Posicion2D posicionActual = Posicion2D.posicionInicial();
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        repeticion.agregarBloque(new Bloque(new MoverHaciaArriba()));
        for (int i = 0; i < repeticiones; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);
        }

        repeticion.agregarBloque(new Bloque(new MoverHaciaArriba()));


        algoritmo.agregarBloque(new Bloque(repeticion));

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        repeticion.removerUltimo();

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test18PuedeRemoverseElUltimoBloqueDeUnBloqueDeInversionYElFuncionamientoEsCorrecto() {
        InvertirComportamiento invertir = new InvertirComportamiento();
        Posicion2D posicionActual = Posicion2D.posicionInicial();

        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        invertir.agregarBloque(new Bloque(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        invertir.agregarBloque(new Bloque(new MoverHaciaArriba()));

        algoritmo.agregarBloque(new Bloque(invertir));

        algoritmo.agregarBloque(new Bloque(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        invertir.removerUltimo();

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }
}
