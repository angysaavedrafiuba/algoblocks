package edu.fiuba.algo3.modelo;

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

        bloque.ejecutar(personaje, new Dibujo());

        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test03elLapizDelPersonajeSeLevantaAlUsarUnBloqueSubirLapiz() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueBajar.ejecutar(personaje, new Dibujo());
        bloqueSubir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test04subirElLapizDelPersonajeNoTieneEfectoSiYaEstaSubido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueSubir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test05bajarElLapizDelPersonajeNoTieneEfectoSiYaEstaBajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(personaje, new Dibujo());
        assertFalse(personaje.lapizEstaArriba());
        bloque.ejecutar(personaje, new Dibujo());

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

        bloque.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test08elPersonajeSeMueveALaIzquierdaAlUsarElBloqueMoverIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverALaIzquierda bloque = new MoverALaIzquierda();
        Posicion2D posicionEsperada = new Posicion2D(-1, 0);

        bloque.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test09elPersonajeSeMueveHaciaArribaAlUsarElBloqueMoverArriba() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaArriba bloque = new MoverHaciaArriba();
        Posicion2D posicionEsperada = new Posicion2D(0, 1);

        bloque.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test10elPersonajeSeMueveHaciaAbajoAlUsarElBloqueMoverAbajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaAbajo bloque = new MoverHaciaAbajo();
        Posicion2D posicionEsperada = new Posicion2D(0, -1);

        bloque.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test11elPersonajeSeMueveDosVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test12elPersonajeSeMueveDosVecesALaIzquierdaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(-2, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test13elPersonajeQuedaEnElMismoLugarAlMoverseDosVecesALaDerechaYDosALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test14elPersonajeSeMueveDosALaIzquierdaYArribaAlUsarBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(-2, 2);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test15elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test16sePuedeAgregarUnBloqueDeRepeticionEnOtroDelMismoTipo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        BloqueAgregable otroBloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(4, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        otroBloqueRepetir.agregarBloque(bloqueRepetir);
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test17elPersonajeSeMueveTresVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test18elPersonajeQuedaEnElMismoLugarAlMoverseTresVecesALaDerechaYTresALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test19elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetir = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        bloqueRepetir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test20sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTriple() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetirDoble = new BloqueAgregable(new BloqueDeRepeticion(2));
        BloqueAgregable bloqueRepetirTriple = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirDoble.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetirTriple.agregarBloque(bloqueRepetirDoble);
        bloqueRepetirTriple.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test21sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDoble() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetirTriple = new BloqueAgregable(new BloqueDeRepeticion(3));
        BloqueAgregable bloqueRepetirDoble = new BloqueAgregable(new BloqueDeRepeticion(2));
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirTriple.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetirDoble.agregarBloque(bloqueRepetirTriple);
        bloqueRepetirDoble.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test22sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTripleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetirDoble = new BloqueAgregable(new BloqueDeRepeticion(2));
        BloqueAgregable bloqueRepetirTriple = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirDoble.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetirTriple.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetirTriple.agregarBloque(bloqueRepetirDoble);
        bloqueRepetirTriple.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetirTriple.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test23sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDobleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueRepetirDoble = new BloqueAgregable(new BloqueDeRepeticion(2));
        BloqueAgregable bloqueRepetirTriple = new BloqueAgregable(new BloqueDeRepeticion(3));
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirTriple.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueRepetirDoble.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetirDoble.agregarBloque(bloqueRepetirTriple);
        bloqueRepetirDoble.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueRepetirDoble.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test24elLapizQuedaSubidoLuegoDeSubirYBajarUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        bloqueInvertir.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        bloqueInvertir.ejecutar(personaje, new Dibujo());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test25elLapizQuedaBajoLuegoDeBajarYSubirUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        bloqueInvertir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        bloqueInvertir.ejecutar(personaje, new Dibujo());

        assertFalse(personaje.lapizEstaArriba());
    }
}
