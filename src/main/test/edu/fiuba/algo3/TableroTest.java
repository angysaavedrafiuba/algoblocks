package edu.fiuba.algo3;
/*
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
*/


public class TableroTest {
/*
    @Test
    public void test01AlInicializarElTableroElDibujoEstaVacio(){
        Tablero tablero= new Tablero();
        
        ArrayList<Posicion> dibujoVacio = tablero.obtenerDibujo();
        tablero.ejecutarAlgoritmo(new ArrayList<Bloque>());

        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test02SinUtilizarElBloqueBajarLapizElDibujoEsVacio(){
        Tablero tablero = new Tablero();
        ArrayList <Bloque> algoritmo = new ArrayList<Bloque>();

        algoritmo.add(new MoverALaDerecha());
        algoritmo.add(new MoverHaciaAbajo());
        algoritmo.add(new MoverALaDerecha());

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion> dibujoVacio = tablero.obtenerDibujo();
        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test03AlBajarElLapizElDibujoEsElEsperado(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion> dibujoEsperado = new ArrayList<Posicion>();
        ArrayList <Bloque> algoritmo = new ArrayList<Bloque>();

        algoritmo.add(new BajarLapiz()); //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));
/*
        algoritmo.add(new MoverALaDerecha()); //(1,0)
        dibujoEsperado.add(new Posicion2D(1,0));

        algoritmo.add(new MoverHaciaAbajo()); //(1,-1)
        dibujoEsperado.add(new Posicion2D(1,-1));

        algoritmo.add(new MoverALaDerecha()); //(2,-1)
        dibujoEsperado.add(new Posicion2D(2,-1));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion> dibujoLogrado = tablero.obtenerDibujo();

        assertEquals(dibujoEsperado, dibujoLogrado);
    }

 */
}
