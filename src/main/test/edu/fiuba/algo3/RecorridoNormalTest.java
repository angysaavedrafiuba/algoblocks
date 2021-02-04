package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RecorridoNormalTest {

    @Test
    public void test01AlAgregar3BloquesElPrimerBloqueEsElPrimeroAgregado(){
            RecorridoNormal recorrido = new RecorridoNormal();

            recorrido.agregar(new BajarLapiz());
            recorrido.agregar(new SubirLapiz());
            recorrido.agregar(new MoverALaIzquierda());

            assertEquals(recorrido.primerBloque().getClass(), BajarLapiz.class);
    }

    @Test
    public void test02AlAgregar3BloquesElPrimerBloqueEsElPrimeroAgregado(){
        RecorridoNormal recorrido = new RecorridoNormal();

        recorrido.agregar(new MoverHaciaAbajo());
        recorrido.agregar(new SubirLapiz());
        recorrido.agregar(new MoverALaIzquierda());

        assertEquals(recorrido.primerBloque().getClass(), MoverHaciaAbajo.class);
    }

}
