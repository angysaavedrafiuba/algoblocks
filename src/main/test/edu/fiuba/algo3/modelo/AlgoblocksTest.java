package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoblocksTest {
    Algoblocks algoblocks = new Algoblocks(); //(10,10)
    ArrayList<Posicion2D> dibujoEsperado = new ArrayList<>(4);
    ArrayList<Posicion2D> dibujoLogrado;
    Posicion2D posicionActual = Posicion2D.posicionInicial();

    @Test
    public void test01IntegracionConBloquesDeMovimientoYLapiz() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        //Ahora comienza a dibujar
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaArriba()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new SubirLapiz()));

        //Ahora no dibuja
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test02IntegracionConBloquesDeMovimientoLapizRepeticionEInversion() {
        int repeticionesDoble = 2;
        int repeticionesTriple = 3;
        BloqueAgregable bloqueDoble = new BloqueAgregable(new BloqueDeRepeticion(repeticionesDoble));
        BloqueAgregable bloqueTriple = new BloqueAgregable(new BloqueDeRepeticion(repeticionesTriple));
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueTriple.agregarBloque(new BloqueDeAccion(new MoverALaIzquierda()));
        algoblocks.agregarBloqueAgregable(bloqueTriple);

        for(int i = 0; i < repeticionesTriple; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.arriba());
            dibujoEsperado.add(posicionActual);
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
            dibujoEsperado.add(posicionActual);
        }

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new SubirLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());

        bloqueDoble.agregarBloque(new BloqueDeAccion(new MoverHaciaArriba()));
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new SubirLapiz()));
        bloqueInvertir.agregarBloque(bloqueDoble);
        bloqueInvertir.agregarBloque(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueAgregable(bloqueInvertir);

        dibujoEsperado.add(posicionActual);
        for(int i = 0; i < repeticionesDoble; i++) {
            posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
            dibujoEsperado.add(posicionActual);
        }

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test03LuegoDeDibujarPosicionesElDibujoSeMantieneAunEjecutandoNuevamenteElAlgoritmo() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

        algoblocks.reiniciarAlgoritmo();
        algoblocks.ejecutar();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test04ELDibujoSigueSiendoConsistenteSiSeReiniciaElAlgoritmoLuegoDeDibujarYSeAgreganNuevosBloques() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05ELDibujoEsConsistenteAlDibujarEliminarBloquesYEjecutarNuevamente() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();
        algoblocks.reiniciarAlgoritmo();
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaIzquierda()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverHaciaAbajo()));
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();
        algoblocks.removerUltimo();

        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.abajo());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test06ElDibujoPuedeReiniciarseYLuegoDibujarNuevamente() {
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

        algoblocks.reiniciarDibujo();
        dibujoLogrado = algoblocks.obtenerDibujo();

        assertTrue(dibujoLogrado.isEmpty());

        dibujoEsperado = new ArrayList<Posicion2D>();
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test07AgregaBloquesDeAccionParaLuegoSerGuardadosEnUnBloquePersonalizadoYDibujaAcordemente(){
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));

        BloqueAgregable bloquePersonalizado = algoblocks.guardarAlgoritmo("unNombre");
        algoblocks.reiniciarAlgoritmo();
        algoblocks.agregarBloqueAgregable(bloquePersonalizado);

        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.derecha());
        dibujoEsperado.add(posicionActual);

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());

    }

    @Test
    public void test08EnUnBloqueDeInversionSeAgregaUnBloquePersonalizableYActuanConsistentemente(){
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new BajarLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        BloqueAgregable bloquePersonalizado = algoblocks.guardarAlgoritmo("unNombre");
        algoblocks.reiniciarAlgoritmo();

        bloqueInvertir.agregarBloque(bloquePersonalizado);

        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertEquals(dibujoLogrado.size(), 0);
    }

    @Test
    public void test09EnBloqueDeInversionSeAgregaSecuenciaConLapizHaciaArribaPeroEsteLoBajaYTrazaUnDibujo(){
        BloqueAgregable bloqueInvertir = new BloqueAgregable(new InvertirComportamiento());

        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new SubirLapiz()));
        algoblocks.agregarBloqueDeAccion(new BloqueDeAccion(new MoverALaDerecha()));
        BloqueAgregable bloquePersonalizado = algoblocks.guardarAlgoritmo("unNombre");
        algoblocks.reiniciarAlgoritmo();

        bloqueInvertir.agregarBloque(bloquePersonalizado);
        
        algoblocks.agregarBloqueAgregable(bloqueInvertir);
        
        dibujoEsperado.add(posicionActual);
        posicionActual = posicionActual.calcularNuevaPosicion(Posicion2D.izquierda());
        dibujoEsperado.add(posicionActual);
        algoblocks.ejecutar();

        dibujoLogrado = algoblocks.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}

