package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class prueba {
    @Test
    public void test01PersonajeSeCrearConLapizArriba() {

        Algoblocks algoblocks = new Algoblocks();
        assertTrue(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test02seCreaUnPersonajeYseEnviaElBloqueLapizAbajoYElLapizAhoraNoEstaArriba() {
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloqueBajarLapiz();
        algoblocks.ejecutar();

        assertFalse(algoblocks.lapizEstaArriba());
    }

    @Test
    public void test03SeBajaYseVuelveASubirElLapizYEsteQuedaHaciaArriba(){

        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloqueBajarLapiz();
        algoblocks.agregarBloqueSubirLapiz();
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());

    }

    @Test
    public void test04SeAplicaBloqueHaciaArribaYEsteNoModificaElEstadoDelLapiz(){
        Algoblocks algoblocks = new Algoblocks();

        algoblocks.agregarBloqueSubirLapiz();
        algoblocks.ejecutar();

        assertTrue(algoblocks.lapizEstaArriba());
    }

    /*
    @Test
    public void test05SeMuevePersonajeHaciaLaDerecha(){

    }*/
}

