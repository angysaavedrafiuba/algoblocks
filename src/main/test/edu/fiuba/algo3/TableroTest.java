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
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
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

    @Test
    public void test04UnBloqueDeRepeticionDobleConMovimientoReflejaUnDibujoAcorde(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new BajarLapiz(), new RecorridoNormal());
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(2);

        //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueRepeticion); //(1, 0) & (2, 0)
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(2,0));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test05UnBloqueDeRepeticionTripleConMovimientoReflejaUnDibujoAcorde(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new BajarLapiz(), new RecorridoNormal());
        BloqueDeRepeticion bloqueRepeticion = new BloqueDeRepeticion(3);

        //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueRepeticion.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueRepeticion); //(-1, 0), (-2, 0) & (-3, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(-2,0));
        dibujoEsperado.add(new Posicion2D(-3,0));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test06VariosBloquesDeRepeticionConMovimientosCombinadosReflejanUnDibujoAcorde(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new BajarLapiz(), new RecorridoNormal());
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);

        //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        bloqueDoble.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(bloqueDoble); //(1, 0), (0, 0), (1, 0) & (0, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(0,0));
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(0,0));
        dibujoEsperado.add(new Posicion2D(1,0));
        dibujoEsperado.add(new Posicion2D(2,0));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        algoritmo.agregarBloque(bloqueTriple); //(0, 1), (0, 2) & (0, 3)
        dibujoEsperado.add(new Posicion2D(2, 1));
        dibujoEsperado.add(new Posicion2D(2, 2));
        dibujoEsperado.add(new Posicion2D(2, 3));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test07UnBloqueDeRepeticionDentroDeUnInvertirComportamientoGeneraUnDibujoAcorde(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new BajarLapiz(), new RecorridoNormal());
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        bloqueDoble.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueDoble); //(-1, 0) & (-2, 0)
        dibujoEsperado.add(new Posicion2D(-1,0));
        dibujoEsperado.add(new Posicion2D(-2,0));

        bloqueInvertir.agregarBloque(new MoverALaIzquierda());
        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(bloqueTriple);
        algoritmo.agregarBloque(bloqueInvertir); //(-2, 1), (-2, 2), (-2, 3) & (-3, 3)

        dibujoEsperado.add(new Posicion2D(-2, 1));
        dibujoEsperado.add(new Posicion2D(-2, 2));
        dibujoEsperado.add(new Posicion2D(-2, 3));
        dibujoEsperado.add(new Posicion2D(-3, 3));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }

    @Test
    public void test08BloquesDeSubirYBajarJuntoConRepeticionEInversionGeneranDibujoAcorde(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<>();
        ColaDeInstrucciones algoritmo = new ColaDeInstrucciones(new RecorridoNormal());
        BloqueDeRepeticion bloqueDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueTriple = new BloqueDeRepeticion(3);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        algoritmo.agregarBloque(new MoverALaDerecha());
        algoritmo.agregarBloque(new MoverALaDerecha());

        algoritmo.agregarBloque(new BajarLapiz()); //(2, 0)
        dibujoEsperado.add(new Posicion2D(2,0));

        bloqueTriple.agregarBloque(new MoverHaciaArriba());
        bloqueTriple.agregarBloque(new MoverALaIzquierda());
        algoritmo.agregarBloque(bloqueTriple); //(2, 1), (1, 1), (1, 2), (0, 2), (2, 3) & (-1, 3)
        dibujoEsperado.add(new Posicion2D(2, 1));
        dibujoEsperado.add(new Posicion2D(1, 1));
        dibujoEsperado.add(new Posicion2D(1, 2));
        dibujoEsperado.add(new Posicion2D(0, 2));
        dibujoEsperado.add(new Posicion2D(0, 3));
        dibujoEsperado.add(new Posicion2D(-1,3));

        algoritmo.agregarBloque(new SubirLapiz());
        algoritmo.agregarBloque(new MoverALaIzquierda());
        bloqueDoble.agregarBloque(new MoverHaciaArriba());
        bloqueInvertir.agregarBloque(bloqueDoble);
        bloqueInvertir.agregarBloque(new BajarLapiz());
        algoritmo.agregarBloque(bloqueInvertir); //(-2, 3), (-2, 4) & (-2, 5)

        dibujoEsperado.add(new Posicion2D(-2, 3));
        dibujoEsperado.add(new Posicion2D(-2, 4));
        dibujoEsperado.add(new Posicion2D(-2, 5));

        algoritmo.agregarBloque(new MoverHaciaAbajo()); //(-2, 4)
        dibujoEsperado.add(new Posicion2D(-2, 4));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertArrayEquals(dibujoEsperado.toArray(), dibujoLogrado.toArray());
    }
}
