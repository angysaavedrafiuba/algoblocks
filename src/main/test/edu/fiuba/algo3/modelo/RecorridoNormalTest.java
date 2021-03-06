package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecorridoNormalTest {
    RecorridoNormal algoritmo = new RecorridoNormal();
    Dibujo dibujo = new Dibujo();
    Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();
    Posicion2D posicionActual = Posicion2D.posicionInicial();

    @Test
    public void test01SeAgregaUnBloqueAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganDosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test02SeAgreganVariosBloquesAUnRecorridoNormalYAlEjecutarloGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        int repeticiones = 3;
        BloqueAgregable repeticion = new BloqueAgregable(new BloqueDeRepeticion(repeticiones));

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        repeticion.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(repeticion);
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        for(int i = 0; i < repeticiones; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);
        }
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test04InvertirUnRecorridoDeUnBloqueGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        BloqueAgregable invertido = new BloqueAgregable(new InvertirComportamiento());

        invertido.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(invertido);
        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test05InvertirUnRecorridoConVariosBloquesGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        BloqueAgregable invertido = new BloqueAgregable(new InvertirComportamiento());

        invertido.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(invertido);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test06InvertirUnRecorridoConBloquesCombinadosGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        int repeticiones = 2;
        BloqueAgregable repeticion = new BloqueAgregable(new BloqueDeRepeticion(repeticiones));
        BloqueAgregable invertido = new BloqueAgregable(new InvertirComportamiento());

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        invertido.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));

        for (int i = 0; i < repeticiones; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        repeticion.agregarBloque(invertido);
        algoritmo.agregarBloque(repeticion);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test07EjecutarDosVecesElMismoRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test08EjecutarUnRecorridoLuegoInvertirloYVolverloAEjecutarDibujaAcordemente() {
        personaje.apoyarLapiz();
        BloqueAgregable invertido = new BloqueAgregable(new InvertirComportamiento());

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(invertido);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test09EjecutarUnRecorridoLuegoDeReiniciarloNoGeneraDibujo() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test10EjecutarUnRecorridoLuegoDeReiniciarYAgregarleBloquesGeneraDibujoAcorde() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();
        algoritmo.ejecutar(personaje, dibujo);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test11CombinarAgregadoDeBloquesConReinicioEInversionDeUnRecorridoGeneraUnDibujoAcorde() {
        personaje.apoyarLapiz();
        BloqueAgregable invertido = new BloqueAgregable(new InvertirComportamiento());

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        invertido.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(invertido);

        algoritmo.ejecutar(personaje, dibujo);

        algoritmo.reiniciar();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        algoritmo.reiniciar();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
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

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.removerUltimo();
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test15PuedeRemoverseUnBloqueYLuegoAgregarUnNuevoYElComportamientoEsCorrecto() {
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.removerUltimo();
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test16IntentarRemoverDeUnRecorridoVacioYLuegoAgregarNuevosBloquesNoCausaProblemas() {
        personaje.apoyarLapiz();

        algoritmo.removerUltimo();
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test17PuedeRemoverseElUltimoBloqueDeUnBloqueDeRepeticionYElFuncionamientoEsCorrecto() {
        int repeticiones = 2;
        BloqueAgregable repeticion = new BloqueAgregable(new BloqueDeRepeticion(repeticiones));
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        repeticion.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        for (int i = 0; i < repeticiones; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);
        }

        repeticion.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));

        algoritmo.agregarBloque(repeticion);

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        repeticion.removerUltimo();

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test18PuedeRemoverseElUltimoBloqueDeUnBloqueDeInversionYElFuncionamientoEsCorrecto() {
        BloqueAgregable invertir = new BloqueAgregable(new InvertirComportamiento());
        personaje.apoyarLapiz();

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        invertir.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        invertir.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(invertir);
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        invertir.removerUltimo();
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test19PuedeAgregarseUnBloqueDeInversionDentroDeOtroYELMovimientoEsElEsperado() {
        BloqueAgregable invertir = new BloqueAgregable(new InvertirComportamiento());
        BloqueAgregable otroInvertir = new BloqueAgregable(new InvertirComportamiento());
        personaje.apoyarLapiz();

        invertir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        otroInvertir.agregarBloque(invertir);
        algoritmo.agregarBloque(otroInvertir);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test20PuedeAgregarseUnBloqueDeInversionDentroDeOtroYELMovimientoEsElEsperadoAunEjecutandoDosVeces() {
        BloqueAgregable invertir = new BloqueAgregable(new InvertirComportamiento());
        BloqueAgregable otroInvertir = new BloqueAgregable(new InvertirComportamiento());
        personaje.apoyarLapiz();

        invertir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        otroInvertir.agregarBloque(invertir);
        algoritmo.agregarBloque(otroInvertir);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }
}
