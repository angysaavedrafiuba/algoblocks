package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void test01AlInicializarElTableroElDibujoEstaVacio(){
        Tablero tablero = new Tablero();
        
        ArrayList<Posicion2D> dibujoVacio = tablero.obtenerDibujo();
        tablero.ejecutarAlgoritmo(new ColaDeInstrucciones(new RecorridoNormal()));

        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test02SinUtilizarElBloqueBajarLapizElDibujoEsVacio(){
        Tablero tablero = new Tablero();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new MoverALaDerecha(), new RecorridoNormal());

        algoritmo.agregarBloque(new MoverHaciaAbajo());
        algoritmo.agregarBloque(new MoverALaDerecha());

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoVacio = tablero.obtenerDibujo();
        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test03AlBajarElLapizElDibujoEsElEsperado(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<Posicion2D>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new BajarLapiz(), new RecorridoNormal());

        //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        algoritmo.agregarBloque(new MoverALaDerecha()); //(1,0)
        dibujoEsperado.add(new Posicion2D(1,0));

        algoritmo.agregarBloque(new MoverHaciaAbajo()); //(1,-1)
        dibujoEsperado.add(new Posicion2D(1,-1));

        algoritmo.agregarBloque(new MoverALaDerecha()); //(2,-1)
        dibujoEsperado.add(new Posicion2D(2,-1));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}
