package edu.fiuba.algo3;

public class RecorridoAlReves implements Recorrido {
    private Bloque primerBloque = new BloqueNulo();

    @Override
    public void agregarBloque(Bloque bloque) {
        bloque.siguiente(primerBloque);
        primerBloque = bloque;
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
