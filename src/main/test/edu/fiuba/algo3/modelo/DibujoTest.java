package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {
    Dibujo dibujo = new Dibujo();
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>();
    RecorridoNormal algoritmo = new RecorridoNormal();
    Posicion2D posicionActual = Posicion2D.posicionInicial();
    Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    int repeticionesDoble = 2;
    int repeticionesTriple = 3;

    @Test
    public void test01ElDibujoSeCreaEnBlanco(){
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test02SiDibujamosLaPosicion2y2LuegoSeEncuentraDibujada(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujar(posicionADibujar);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test03DibujarConUnLapizHaciaArribaNoProduceDibujo(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);

        dibujo.dibujarConLapiz(posicionADibujar, new Lapiz());
        assertTrue(dibujo.enBlanco());
    }

    @Test
    public void test04SiDibujamosLaPosicion2y2ConUnLapizHaciaAbajoEfectivamenteSeDibuja(){
        Posicion2D posicionADibujar = new Posicion2D(2,2);
        Lapiz lapiz = new Lapiz();
        lapiz.apoyar();

        dibujo.dibujarConLapiz(posicionADibujar, lapiz);
        assertTrue(dibujo.estaDibujada(posicionADibujar));
    }

    @Test
    public void test05IntercalarLapizLevantadoYApoyadoNoAfectaElComportamientoDelDibujo() {
        Lapiz lapizApoyado = new Lapiz();
        lapizApoyado.apoyar();
        Lapiz lapizLevantado = new Lapiz();

        dibujo.dibujarConLapiz(new Posicion2D(10, 11), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(10, 11));

        dibujo.dibujarConLapiz(new Posicion2D(10, 12), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(11, 12), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(11, 12));

        dibujo.dibujarConLapiz(new Posicion2D(12, 12), lapizLevantado);
        dibujo.dibujarConLapiz(new Posicion2D(12, 13), lapizApoyado);
        dibujoEsperado.add(new Posicion2D(12, 13));

        assertArrayEquals(dibujo.posicionesDibujadas().toArray(), dibujoEsperado.toArray());
    }

    @Test
    public void test04UnBloqueDeRepeticionDobleConMovimientoReflejaUnDibujoAcorde(){
        BloqueAgregable bloqueRepeticion = new BloqueAgregable(new BloqueDeRepeticion(2));

        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueRepeticion.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(bloqueRepeticion);

        for(int i = 0; i < repeticionesDoble; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.ejecutar(personaje, dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05UnBloqueDeRepeticionTripleConMovimientoReflejaUnDibujoAcorde(){
        int repeticionTriple = 3;
        BloqueAgregable bloqueRepeticion = new BloqueAgregable(new BloqueDeRepeticion(repeticionTriple));

        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueRepeticion.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoritmo.agregarBloque(bloqueRepeticion);

        for(int i = 0; i < repeticionTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.ejecutar(new Personaje(Posicion2D.posicionInicial()), dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test06VariosBloquesDeRepeticionConMovimientosCombinadosReflejanUnDibujoAcorde(){
        BloqueAgregable bloqueDoble = new BloqueAgregable(new BloqueDeRepeticion(repeticionesDoble));
        BloqueAgregable bloqueTriple = new BloqueAgregable(new BloqueDeRepeticion(repeticionesTriple));

        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(bloqueDoble);

        for(int i = 0; i < repeticionesDoble; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
            dibujoEsperado.add(posicionActual);
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
            dibujoEsperado.add(posicionActual);
        }

        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        algoritmo.agregarBloque(bloqueTriple);

        for(int i = 0; i < repeticionesTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.ejecutar(personaje, dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test07UnBloqueDeRepeticionDentroDeUnInvertirComportamientoGeneraUnDibujoAcorde(){
        BloqueAgregable bloqueDoble = new BloqueAgregable(new BloqueDeRepeticion(repeticionesDoble));
        BloqueAgregable bloqueTriple = new BloqueAgregable(new BloqueDeRepeticion(repeticionesTriple));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        dibujoEsperado.add(posicionActual);

        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoritmo.agregarBloque(bloqueDoble);

        for(int i = 0; i < repeticionesDoble; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        bloqueInvertir.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(bloqueTriple);
        algoritmo.agregarBloque(bloqueInvertir);

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        for(int i = 0; i < repeticionesTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);
        }
        algoritmo.ejecutar(personaje, dibujo);

        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test08BloquesDeSubirYBajarJuntoConRepeticionEInversionGeneranDibujoAcorde(){
        BloqueAgregable bloqueDoble = new BloqueAgregable(new BloqueDeRepeticion(repeticionesDoble));
        BloqueAgregable bloqueTriple = new BloqueAgregable(new BloqueDeRepeticion(repeticionesTriple));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoritmo.agregarBloque(bloqueTriple);

        for (int i = 0; i < repeticionesTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);

            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(bloqueDoble);
        algoritmo.agregarBloque(bloqueInvertir);

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        for (int i = 0; i < repeticionesTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);
        }

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());

        algoritmo.ejecutar(new Personaje(Posicion2D.posicionInicial()), dibujo);
        ArrayList<Posicion2D> dibujoLogrado = dibujo.posicionesDibujadas();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test09ElDibujoSeEncuentraEnBlancoLuegoDeReiniciarlo() {
        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());

        dibujo.reiniciar();
        dibujoEsperado = new ArrayList<>();

        assertTrue(dibujo.posicionesDibujadas().isEmpty());
    }

    @Test
    public void test10PuedoVolverADibujarLuegoDeReiniciarElDibujo() {
        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        dibujo.reiniciar();

        dibujoEsperado = new ArrayList<>();
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(), dibujo.posicionesDibujadas().toArray());
    }

    @Test
    public void test11AlAgregarBloqueAlgoritmoPersonalizadoEsteDibujaCorrectamente(){
        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));

        BloqueAgregable bloquePersonalizado = algoritmo.guardarSecuenciaConNombre("pepito");
        algoritmo.reiniciar();

        algoritmo.agregarBloque(bloquePersonalizado);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(),dibujo.posicionesDibujadas().toArray());

    }

    @Test
    public void test12SeInvierteBloquePersonalizadoYEsteDibujaDeFormaCorrecta(){
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoritmo.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));

        BloqueAgregable bloquePersonalizado = algoritmo.guardarSecuenciaConNombre("fulanito");
        algoritmo.reiniciar();

        bloqueInvertir.agregarBloque(bloquePersonalizado);
        algoritmo.agregarBloque(bloqueInvertir);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        assertArrayEquals(dibujoEsperado.toArray(),dibujo.posicionesDibujadas().toArray());

    }

    @Test
    public void test13ABloquePersonalizadoSeLoInvierteLuegoSeVulveAAgregarYEsteConservaLaSecuenciaYDibujaCorrectamente(){
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));

        BloqueAgregable bloquePersonalizado = algoritmo.guardarSecuenciaConNombre("fulanito");
        algoritmo.reiniciar();

        bloqueInvertir.agregarBloque(bloquePersonalizado);
        algoritmo.agregarBloque(bloqueInvertir);

        algoritmo.reiniciar();

        algoritmo.agregarBloque(bloquePersonalizado);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoritmo.ejecutar(personaje, dibujo);
        assertArrayEquals(dibujoEsperado.toArray(),dibujo.posicionesDibujadas().toArray());


    }

    @Test
    public void test14SeAgreganDosBloquesPersonalizadosYEstosDibujanAcordemente(){
        algoritmo.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaDerecha()));
        algoritmo.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        BloqueAgregable bloquePersonalizado1 = algoritmo.guardarSecuenciaConNombre("pepito");

        algoritmo.agregarBloque(new BloqueDeAccion(new MoverHaciaAbajo()));
        BloqueAgregable bloquePersonalizado2 = algoritmo.guardarSecuenciaConNombre("juancito");

        algoritmo.agregarBloque(bloquePersonalizado1);
        algoritmo.agregarBloque(bloquePersonalizado2);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);


        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);


        algoritmo.ejecutar(personaje, dibujo);

        assertArrayEquals(dibujoEsperado.toArray(),dibujo.posicionesDibujadas().toArray());

    }
}