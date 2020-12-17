package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoBlocksTest {
    @Test
    public void test01PersonajeSeCrearConLapizArriba() {

        Algoblocks algoblocks = new Algoblocks();
        assertTrue(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test02seCreaUnPersonajeYseEnviaElBloqueLapizAbajoYElLapizAhoraNoEstaArriba() {
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.ejecutar();

        assertFalse(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test03SeBajaYseVuelveASubirElLapizYEsteQuedaHaciaArriba(){

        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());

    }

    @Test
    public void test04SeAplicaBloqueHaciaArribaYEsteNoModificaElEstadoDelLapiz(){
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloque(new SubirLapiz());
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());
    }
}

