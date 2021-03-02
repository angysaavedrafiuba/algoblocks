package edu.fiuba.algo3.servicios;

import edu.fiuba.algo3.modelo.*;

import java.util.HashMap;

public class ServicioImagenes {

    private HashMap<String, String> mapeoDeImagenes = new HashMap<>();

    private ServicioImagenes(){
        mapeoDeImagenes.put(new BloqueDeAccion(new MoverHaciaArriba()).toString()  , "draw-north.png");
        mapeoDeImagenes.put(new BloqueDeAccion(new MoverALaDerecha()).toString()   , "draw-east.png");
        mapeoDeImagenes.put(new BloqueDeAccion(new MoverHaciaAbajo()).toString()   , "draw-south.png");
        mapeoDeImagenes.put(new BloqueDeAccion(new MoverALaIzquierda()).toString() , "draw-west.png");
        mapeoDeImagenes.put(new BloqueDeAccion(new SubirLapiz()).toString()        , "subir.png");
        mapeoDeImagenes.put(new BloqueDeAccion(new BajarLapiz()).toString()        , "bajar.png");

        mapeoDeImagenes.put(new BloqueAgregable(new BloqueDeRepeticion(0)).toString(), "repeticion.png");
        mapeoDeImagenes.put(new BloqueAgregable(new InvertirComportamiento()).toString(), "invertir.png");
    }

    private static ServicioImagenes instance = new ServicioImagenes();

    public static ServicioImagenes getInstance() {
        return instance;
    }


    public String imagenCorrespondienteA(Bloque bloque) {
        return mapeoDeImagenes.get(bloque.toString());
    }
}
