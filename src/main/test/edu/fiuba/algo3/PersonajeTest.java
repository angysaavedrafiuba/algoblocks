package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01alCrearseUnPersonajeSuLapizEstaArriba() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test02elLapizDelPersonajeSeBajaAlUsarUnBloqueBajarLapiz() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test03elLapizDelPersonajeSeLevantaAlUsarUnBloqueSubirLapiz() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueBajar.ejecutar(personaje, new Tablero());
        bloqueSubir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test04subirElLapizDelPersonajeNoTieneEfectoSiYaEstaSubido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueSubir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test05bajarElLapizDelPersonajeNoTieneEfectoSiYaEstaBajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(personaje, new Tablero());
        assertFalse(personaje.lapizEstaArriba());
        bloque.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test06elPersonajeSeCreaEnLaPosicionInicial00() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        Posicion2D posicion = new Posicion2D(0, 0);

        assertTrue(personaje.estaEn(posicion));
    }

    @Test
    public void test07elPersonajeSeMueveALaDerechaAlUsarElBloqueMoverDerecha() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverALaDerecha bloque = new MoverALaDerecha();
        Posicion2D posicionEsperada = new Posicion2D(1, 0);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test08elPersonajeSeMueveALaIzquierdaAlUsarElBloqueMoverIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverALaIzquierda bloque = new MoverALaIzquierda();
        Posicion2D posicionEsperada = new Posicion2D(-1, 0);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test09elPersonajeSeMueveHaciaArribaAlUsarElBloqueMoverArriba() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaArriba bloque = new MoverHaciaArriba();
        Posicion2D posicionEsperada = new Posicion2D(0, 1);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test10elPersonajeSeMueveHaciaAbajoAlUsarElBloqueMoverAbajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaAbajo bloque = new MoverHaciaAbajo();
        Posicion2D posicionEsperada = new Posicion2D(0, -1);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test11elPersonajeSeMueveDosVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test12elPersonajeSeMueveDosVecesALaIzquierdaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(-2, 0);

        bloqueRepetir.agregarBloque(new MoverALaIzquierda());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test13elPersonajeQuedaEnElMismoLugarAlMoverseDosVecesALaDerechaYDosALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.agregarBloque(new MoverALaIzquierda());
        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test14elPersonajeSeMueveDosALaIzquierdaYArribaAlUsarBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(-2, 2);

        bloqueRepetir.agregarBloque(new MoverALaIzquierda());
        bloqueRepetir.agregarBloque(new MoverHaciaArriba());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test15elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.agregarBloque(new BajarLapiz());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test16sePuedeAgregarUnBloqueDeRepeticionEnOtroDelMismoTipo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetir = new RepetirDosVeces();
        RepetirDosVeces otroBloqueRepetir = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(4, 0);

        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        otroBloqueRepetir.agregarBloque(bloqueRepetir);
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test17elPersonajeSeMueveTresVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirTresVeces bloqueRepetir = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test18elPersonajeQuedaEnElMismoLugarAlMoverseTresVecesALaDerechaYTresALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirTresVeces bloqueRepetir = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.agregarBloque(new MoverALaIzquierda());
        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test19elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirTresVeces bloqueRepetir = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.agregarBloque(new MoverALaDerecha());
        bloqueRepetir.agregarBloque(new BajarLapiz());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test20sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTriple() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetirDoble = new RepetirDosVeces();
        RepetirTresVeces bloqueRepetirTriple = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirDoble.agregarBloque(new MoverALaDerecha());
        bloqueRepetirTriple.agregarBloque(bloqueRepetirDoble);
        bloqueRepetirTriple.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test21sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDoble() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirTresVeces bloqueRepetirTriple = new RepetirTresVeces();
        RepetirDosVeces bloqueRepetirDoble = new RepetirDosVeces();
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirTriple.agregarBloque(new MoverALaDerecha());
        bloqueRepetirDoble.agregarBloque(bloqueRepetirTriple);
        bloqueRepetirDoble.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test22sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTripleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetirDoble = new RepetirDosVeces();
        RepetirTresVeces bloqueRepetirTriple = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirDoble.agregarBloque(new MoverALaDerecha());
        bloqueRepetirTriple.agregarBloque(new MoverALaIzquierda());
        bloqueRepetirTriple.agregarBloque(bloqueRepetirDoble);
        bloqueRepetirTriple.agregarBloque(new MoverALaIzquierda());
        bloqueRepetirTriple.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test23sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDobleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        RepetirDosVeces bloqueRepetirDoble = new RepetirDosVeces();
        RepetirTresVeces bloqueRepetirTriple = new RepetirTresVeces();
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirTriple.agregarBloque(new MoverALaDerecha());
        bloqueRepetirDoble.agregarBloque(new MoverALaIzquierda());
        bloqueRepetirDoble.agregarBloque(bloqueRepetirTriple);
        bloqueRepetirDoble.agregarBloque(new MoverALaIzquierda());
        bloqueRepetirDoble.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test24elLapizQuedaSubidoLuegoDeSubirYBajarUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.agregarBloque(new BajarLapiz());
        bloqueInvertir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test25elLapizQuedaBajoLuegoDeBajarYSubirUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        bloqueInvertir.agregarBloque(new BajarLapiz());
        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }
}
