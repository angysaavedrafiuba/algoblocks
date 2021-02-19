package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Posicion2DTest {

    @Test
    public void test01CompararDosPosiciones1y0DevuelveTrue(){
        Posicion2D posicion = new Posicion2D(1,0);

        assertTrue(posicion.esLaMismaQue(new Posicion2D(1,0)));
    }

    @Test
    public void test02MoverLaPosicion1y0ALaDerechaDaComoResultadoLaPosicion2y0(){
        Posicion2D posicion = new Posicion2D(1,0);
        posicion = posicion.calcularNuevaPosicion(Posicion2D.derecha());

        assertTrue(posicion.esLaMismaQue(new Posicion2D(2,0)));
    }

    @Test
    public void test03MoverLaPosicion1y0ALaIzquierdaDaComoResultadoLaPosicion0y0(){
        Posicion2D posicion = new Posicion2D(1,0);
        posicion = posicion.calcularNuevaPosicion(Posicion2D.izquierda());

        assertTrue(posicion.esLaMismaQue(new Posicion2D(0,0)));
    }

    @Test
    public void test04MoverLaPosicion0y1HaciaArribaDaComoResultadoLaPosicion0y2(){
        Posicion2D posicion = new Posicion2D(0,1);
        posicion = posicion.calcularNuevaPosicion(Posicion2D.arriba());

        assertTrue(posicion.esLaMismaQue(new Posicion2D(0,2)));
    }

    @Test
    public void test05MoverLaPosicion0y1HaciaAbajoDaComoResultadoLaPosicion0y0(){
        Posicion2D posicion = new Posicion2D(0,1);
        posicion = posicion.calcularNuevaPosicion(Posicion2D.abajo());

        assertTrue(posicion.esLaMismaQue(new Posicion2D(0,0)));
    }

    @Test
    public void test06MoverLaPosicion2y3SegunLaPosicion1y5DaComoResultadoLaPosicion3y8(){
        Posicion2D posicion = new Posicion2D(2,3);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(1,5));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(3,8)));
    }

    @Test
    public void test07MoverLaPosicion2y3SegunLaPosicion0y0DaComoResultadoLaMismaPosicion2y3(){
        Posicion2D posicion = new Posicion2D(2,3);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(0,0));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(2,3)));
    }

    @Test
    public void test08MoverLaPosicion2y3SegunLaPosicionMenos1yMenos1DaComoResultadoLaMismaPosicion1y2(){
        Posicion2D posicion = new Posicion2D(2,3);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(-1,-1));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(1,2)));
    }

    @Test
    public void test09MoverseHaciaArribaEnLaAlturaYIgualA20ExcedeElLimiteSuperiorYVuelveA0(){
        Posicion2D posicion = new Posicion2D(10,20);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(0,1));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(10,0)));
    }

    @Test
    public void test10MoverseHaciaAbajoEnLaAlturaYIgualA0ExcedeElLimiteInferiorYVuelveA20(){
        Posicion2D posicion = new Posicion2D(10,0);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(0,-1));

        System.out.println((-1)%21);

        assertTrue(posicion.esLaMismaQue(new Posicion2D(10,20)));
    }

    @Test
    public void test11MoverseHaciaArribaEnLaAlturaXIgualA20ExcedeElLimiteSuperiorYVuelveA0(){
        Posicion2D posicion = new Posicion2D(20,10);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(1,0));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(0,10)));
    }

    @Test
    public void test12MoverseHaciaArribaEnLaAlturaXIgualA0ExcedeElLimiteInferiorYVuelveA0(){
        Posicion2D posicion = new Posicion2D(0,10);
        posicion = posicion.calcularNuevaPosicion(new Posicion2D(-1,0));

        assertTrue(posicion.esLaMismaQue(new Posicion2D(20,10)));
    }
}
