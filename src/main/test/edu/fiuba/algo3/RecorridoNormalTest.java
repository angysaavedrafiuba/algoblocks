package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecorridoNormalTest {

    @Test
    public void test01AlAgregarBloquesElPrimerBloqueEsElPrimeroAgregado(){
            RecorridoNormal recorrido = new RecorridoNormal();

            recorrido.agregarBloque(new BajarLapiz());
            recorrido.agregarBloque(new SubirLapiz());
            recorrido.agregarBloque(new MoverALaIzquierda());

            assertEquals(recorrido.primerBloque().getClass(), BajarLapiz.class);
    }

    @Test
    public void test02AlAgregarBloquesElPrimerBloqueEsElPrimeroAgregado(){
        RecorridoNormal recorrido = new RecorridoNormal();

        recorrido.agregarBloque(new MoverHaciaAbajo());
        recorrido.agregarBloque(new SubirLapiz());
        recorrido.agregarBloque(new MoverALaIzquierda());

        assertEquals(recorrido.primerBloque().getClass(), MoverHaciaAbajo.class);
    }

}
