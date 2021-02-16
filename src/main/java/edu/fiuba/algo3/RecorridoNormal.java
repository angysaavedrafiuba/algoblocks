package edu.fiuba.algo3;

public class RecorridoNormal implements Recorrido {
    private Bloque primerBloque;
    private Bloque ultimoBloque = new BloqueNulo();

    RecorridoNormal() {
        primerBloque = ultimoBloque;
    }

    @Override
    public void agregarBloque(Bloque bloque){
        ultimoBloque.siguiente(bloque);
        ultimoBloque = bloque;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        primerBloque.ejecutar(personaje, dibujo);
    }

    @Override
    public void invertir() {
        primerBloque = primerBloque.invertirSecuencia();
    }

    /* Test only */
    public Bloque primerBloque() {
        return primerBloque;
    }
}
