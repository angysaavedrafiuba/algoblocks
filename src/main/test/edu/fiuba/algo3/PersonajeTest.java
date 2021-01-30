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
        Posicion2D posicion = new Posicion2D(0,0);

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
}
